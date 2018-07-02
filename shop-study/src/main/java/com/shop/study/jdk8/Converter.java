package com.shop.study.jdk8;

@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}
