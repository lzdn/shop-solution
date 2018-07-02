package com.xiangqin.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.xiangqin.domain.dto.WeiXinDto;

public class WeixinUtil {

	public static final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	public static final String URL = "http://xiangqin.defa1688.com/index.html";
	public static final String JS_ACCESS_TOKEN_API = "https://api.weixin.qq.com/cgi-bin/token";
	public static final String JS_WX_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	public static final String APP_ID = "wx6978551c71d8a51d";
	public static final String APP_SECRET = "43c4c8993841ccc22a71d1580fd949ed";
	public static final int DEFAULT_NONCESTR_LENGTH = 16;
	public static final String ACCESS_TOKEN_CACHE_KEY = "access_token_cache_key";
	public static final String TICKET_CACHE_KEY = "ticket_cache_key";
	public static final String WEIXIN_CACHE_KEY = "weixin_cache_key";

	// 生成随机字符串
	public static String generateNonceStr(Random random, String characters, int length) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
	}

	public static String defaultNonceStr() {
		return generateNonceStr(new Random(), SOURCES, DEFAULT_NONCESTR_LENGTH);
	}

	public static WeiXinDto signature(String jsapi_ticket) {
		WeiXinDto dto = new WeiXinDto();
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		String noncestr = defaultNonceStr();
		String str = null;
		try {
			str = getSignature(jsapi_ticket, timestamp, noncestr, URL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dto.setAppId(APP_ID);
		dto.setNonceStr(noncestr);
		dto.setTimestamp(timestamp);
		dto.setSignature(str);
		return dto;
	}

	public static String getAccessToken(String appId, String appSecret) {
		if (StringUtils.isEmpty(appId))
			appId = APP_ID;
		if (StringUtils.isEmpty(appSecret))
			appSecret = APP_SECRET;
		String json = HttpUtil.sendGet(JS_ACCESS_TOKEN_API,
				"?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret);
		JSONObject obj = JSONObject.parseObject(json);
		String access_token = obj.getString("access_token");
		return access_token;
	}

	public static String getTicket(String access_token) {
		// ?access_token=ACCESS_TOKEN&type=jsapi
		String json = HttpUtil.sendGet(JS_WX_TICKET, "?access_token=" + access_token + "&type=jsapi");
		JSONObject obj = JSONObject.parseObject(json);
		String ticket = obj.getString("ticket");
		return ticket;
	}

	// 获得js signature
	public static String getSignature(String jsapi_ticket, String timestamp, String nonce, String jsurl)
			throws IOException {
		/****
		 * 对 jsapi_ticket、 timestamp 和 nonce 按字典排序 对所有待签名参数按照字段名的 ASCII 码从小到大排序（字典序）后，使用
		 * URL 键值对的格式（即key1=value1&key2=value2…）拼接成字符串 string1。这里需要注意的是所有参数名均为小写字符。 接下来对
		 * string1 作 sha1 加密，字段名和字段值都采用原始值，不进行 URL 转义。即 signature=sha1(string1)。
		 * **如果没有按照生成的key1=value&key2=value拼接的话会报错
		 */
		String[] paramArr = new String[] { "jsapi_ticket=" + jsapi_ticket, "timestamp=" + timestamp,
				"noncestr=" + nonce, "url=" + jsurl };
		Arrays.sort(paramArr);
		// 将排序后的结果拼接成一个字符串
		String content = paramArr[0].concat("&" + paramArr[1]).concat("&" + paramArr[2]).concat("&" + paramArr[3]);
		System.out.println("拼接之后的content为:" + content);
		String gensignature = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			// 对拼接后的字符串进行 sha1 加密
			byte[] digest = md.digest(content.toString().getBytes());
			gensignature = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 将 sha1 加密后的字符串与 signature 进行对比
		if (gensignature != null) {
			return gensignature.toLowerCase();// 返回signature
		} else {
			return "";
		}
	}

	/**
	 * 将字节数组转换为十六进制字符串
	 *
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 *
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		String s = new String(tempArr);
		return s;
	}

}
