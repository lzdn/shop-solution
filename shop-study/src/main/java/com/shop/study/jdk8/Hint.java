package com.shop.study.jdk8;

import java.lang.annotation.Repeatable;

@Repeatable(Hints.class)
public @interface Hint {
	String value();
}
