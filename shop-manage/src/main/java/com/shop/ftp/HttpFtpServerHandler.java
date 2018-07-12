package com.shop.ftp;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static io.netty.handler.codec.http.HttpResponseStatus.FOUND;
import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;
import static io.netty.handler.codec.http.HttpResponseStatus.METHOD_NOT_ALLOWED;
import static io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressiveFuture;
import io.netty.channel.ChannelProgressiveFutureListener;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.stream.ChunkedFile;
import io.netty.util.CharsetUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

import javax.activation.MimetypesFileTypeMap;

public class HttpFtpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	private final String url;

	public HttpFtpServerHandler(String url) {
		this.url = url;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, FullHttpRequest arg1) throws Exception {
		messageReceived(arg0, arg1);
	}

	public void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {

		// 过滤掉浏览器每次发起请求，都会同时请求一次favicon.ico
		if (request.uri().equals("/favicon.ico")) {
			return;
		}

		System.out.println("服务器接受消息" + request);

		// 首先对HTTP请求小弟的解码结果进行判断，如果解码失败，直接构造HTTP 400错误返回。
		if (!request.decoderResult().isSuccess()) {
			sendError(ctx, BAD_REQUEST);
			return;
		}
		// 请求方法：如果不是从浏览器或者表单设置为get请求，构造http 405错误返回
		if (request.method() != GET) {
			sendError(ctx, METHOD_NOT_ALLOWED);
			return;
		}
		// 对请求的的URL进行包装
		final String uri = request.uri();
		// 展开URL分析
		final String path = sanitizeUri(uri);

		if (path == null) {
			sendError(ctx, FORBIDDEN);
			return;
		}
		File file = new File(path);
		// 如果文件不存在或者是系统隐藏文件，则构造404 异常返回
		if (file.isHidden() || !file.exists()) {
			sendError(ctx, NOT_FOUND);
			return;
		}
		// 如果文件是目录，则发送目录的连接给客户端浏览器
		if (file.isDirectory()) {
			if (uri.endsWith("/")) {
				sendListing(ctx, file);
			} else {
				sendRedirect(ctx, uri + '/');
			}
			return;
		}
		// 用户在浏览器上第几超链接直接打开或者下载文件，合法性监测
		if (!file.isFile()) {
			sendError(ctx, FORBIDDEN);
			return;
		}

		// IE下才会打开文件，其他浏览器都是直接下载
		// 随机文件读写类以读的方式打开文件
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file, "r");// 以只读的方式打开文件
		} catch (FileNotFoundException fnfe) {
			sendError(ctx, NOT_FOUND);
			return;
		}
		// 获取文件长度，构建成功的http应答消息
		long fileLength = randomAccessFile.length();
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
		HttpUtil.setContentLength(response, fileLength);
		setContentTypeHeader(response, file);
		if (HttpUtil.isKeepAlive(request)) {
			response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
		}
		ctx.write(response);

		ChannelFuture sendFileFuture;
		// 同过netty的村可多File对象直接将文件写入到发送缓冲区，最后为sendFileFeature增加GenericFeatureListener，
		// 如果发送完成，打印“Transfer complete”
		sendFileFuture = ctx.write(new ChunkedFile(randomAccessFile, 0, fileLength, 8192), ctx.newProgressivePromise());
		sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
			@Override
			public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) {
				if (total < 0) { // total unknown
					System.err.println("Transfer progress: " + progress);
				} else {
					System.err.println("Transfer progress: " + progress + " / " + total);
				}
			}

			@Override
			public void operationComplete(ChannelProgressiveFuture future) throws Exception {
				System.out.println("Transfer complete.");
			}
		});
		ChannelFuture lastContentFuture = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);

		if (!HttpUtil.isKeepAlive(request)) {
			lastContentFuture.addListener(ChannelFutureListener.CLOSE);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		if (ctx.channel().isActive()) {
			sendError(ctx, INTERNAL_SERVER_ERROR);
		}
	}

	private static final Pattern INSECURE_URI = Pattern.compile(".*[<>&\"].*");

	private String sanitizeUri(String uri) {

		try {
			// 使用JDK的URLDecoder进行解码
			uri = URLDecoder.decode(uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			try {
				uri = URLDecoder.decode(uri, "ISO-8859-1");
			} catch (UnsupportedEncodingException e1) {
				throw new Error();
			}
		}
		// URL合法性判断
		if (!uri.startsWith(url)) {
			return null;
		}
		if (!uri.startsWith("/")) {
			return null;
		}
		// 将硬编码的文件路径
		uri = uri.replace('/', File.separatorChar);
		if (uri.contains(File.separator + '.') || uri.contains('.' + File.separator) || uri.startsWith(".")
				|| uri.endsWith(".") || INSECURE_URI.matcher(uri).matches()) {
			return null;
		}
		return System.getProperty("user.dir") + File.separator + uri;
	}

	private static final Pattern ALLOWED_FILE_NAME = Pattern.compile("[A-Za-z0-9][-_A-Za-z0-9\\.]*");

	/**
	 * 这里是构建了一个html页面返回给浏览器
	 * 
	 * @param ctx
	 * @param dir
	 */
	private static void sendListing(ChannelHandlerContext ctx, File dir) {
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
		StringBuilder buf = new StringBuilder();
		String dirPath = dir.getPath();
		buf.append("<!DOCTYPE html>\r\n");
		buf.append("<html><head><title>");
		buf.append(dirPath);
		buf.append(" 目录：");
		buf.append("</title></head><body>\r\n");
		buf.append("<h3>");
		buf.append(dirPath).append(" 目录：");
		buf.append("</h3>\r\n");
		buf.append("<ul>");
		// 此处打印了一个 .. 的链接
		buf.append("<li>链接：<a href=\"../\">..</a></li>\r\n");
		// 用于展示根目录下的所有文件和文件夹，同时使用超链接标识
		for (File f : dir.listFiles()) {
			if (f.isHidden() || !f.canRead()) {
				continue;
			}
			String name = f.getName();
			if (!ALLOWED_FILE_NAME.matcher(name).matches()) {
				continue;
			}
			buf.append("<li>链接：<a href=\"");
			buf.append(name);
			buf.append("\">");
			buf.append(name);
			buf.append("</a></li>\r\n");
		}
		buf.append("</ul></body></html>\r\n");
		ByteBuf buffer = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
		response.content().writeBytes(buffer);
		buffer.release();
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	private static void sendRedirect(ChannelHandlerContext ctx, String newUri) {
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, FOUND);
		response.headers().set(HttpHeaderNames.LOCATION, newUri);
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {

		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, status,
				Unpooled.copiedBuffer("Failure: " + status.toString() + "\r\n", CharsetUtil.UTF_8));
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	private static void setContentTypeHeader(HttpResponse response, File file) {

		MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, mimeTypesMap.getContentType(file.getPath()));
	}

}
