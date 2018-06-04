package com.shop.utils;

import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class MD5Util {

	public static final String SALT = "@ad902s^$";

	private static final String BASE_RANDOM = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890@^$";

	private static final int len = 9;

	public static String getRandomSalt() {
		// 定义一个字符串（A-Z，a-z，0-9）即62位；
		// 由Random生成随机数
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		// 长度为几就循环几次
		for (int i = 0; i < len; ++i) {
			// 产生0-61的数字
			int number = random.nextInt(62);
			// 将产生的数字通过length次承载到sb中
			sb.append(BASE_RANDOM.charAt(number));
		}
		// 将承载的字符转换成字符串
		return sb.toString();
	}

	public static String encode(String password, String salt) {

		if (StringUtils.isEmpty(salt))
			return encode(password);

		password = password + salt;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		char[] charArray = password.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}

			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	public static String encode(String password) {
		password = password + SALT;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		char[] charArray = password.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}

			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.encode("123", MD5Util.getRandomSalt()));
	}

}
