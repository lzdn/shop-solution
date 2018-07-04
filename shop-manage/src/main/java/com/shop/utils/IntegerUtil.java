package com.shop.utils;

public class IntegerUtil {

	public static boolean isNotNullAndNotZero(Integer value) {
		if (value != null && value.intValue() != 0)
			return true;
		return false;
	}
}
