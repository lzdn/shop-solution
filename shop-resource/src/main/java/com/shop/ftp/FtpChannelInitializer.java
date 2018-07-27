package com.shop.ftp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

@Component
@Qualifier("ftpChannelInitializer")
public class FtpChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {

		channel.pipeline().addLast("http-decoder", new HttpRequestDecoder());
		channel.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
		// 新增HTTP响应编码器，对HTTP响应消息进行编码
		channel.pipeline().addLast("http-encoder", new HttpResponseEncoder());
		// 新增Chunked handler，主要作用是支持异步发送大的码流（例如大文件传输）
		// 但是不占用过多的内存，防止发生java内存溢出错误
		channel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
		// HttpFileServerHandler用于文件服务器的业务逻辑处理
		channel.pipeline().addLast("fileServerHandler", new HttpFtpServerHandler("/upload"));

	}

}
