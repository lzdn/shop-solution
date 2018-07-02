package com.shop.study.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

 
//http://www.importnew.com/10360.html
public class Excute {

	public static void defInterFace() {
		// jdk1.8 接口可以有默认的实现方法
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		System.out.println(formula.calculate(5));
		System.err.println(formula.sqrt(600));//默认方法可以直接调用
	}

	// jdk1.8之前
	public static void mySort() {
		List<String> names = Arrays.asList("mike","peter", "anna", "mike","xenia", "mike");
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		System.out.println(names.toString());
	}

	// Lambda表达式
	public static void LambdaM() {
		List<String> names = Arrays.asList("mike","peter", "anna", "mike","xenia", "mike");
		
		/*
		 方法1
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		*/
		/*
		 * 	 方法2
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		 */
		//方法3 jdk自动识别类型
		Collections.sort(names, (a, b) -> b.compareTo(a));
		//Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println(names.toString());
	}

	class Something {
	    String startsWith(String s) {
	        return String.valueOf(s.charAt(0));
	    }
	}

	public  void lambdaN() {
		// 方法1 Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		// 方法2 通过关键字 :: 引用
//		Converter<String, Integer> converter = Integer::valueOf;
//		Integer converted = converter.convert("123");
//		System.out.println(converted);    // 123
		
		Something something = new Something();
		Converter<String, String> converter = something::startsWith;
		String converted = converter.convert("Java");
		System.out.println(converted);    // "J"
	}
	
	public static void callStreams() {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		//filter
		stringCollection
	    .stream()
	    .filter((s) -> s.startsWith("a"))
	    .forEach(System.out::println);
		//Sorted
		stringCollection
	    .stream()
	    .sorted()
	    .filter((s) -> s.startsWith("a"))
	    .forEach(System.out::println);
		//Map
		stringCollection
	    .stream()
	    .map(String::toUpperCase)
	    .sorted((a, b) -> b.compareTo(a))
	    .forEach(System.out::println);
		//Match
		boolean anyStartsWithA = 
			    stringCollection
			        .stream()
			        .anyMatch((s) -> s.startsWith("a"));
			 
		System.out.println(anyStartsWithA);      // true
			 
		boolean allStartsWithA = 
			    stringCollection
			        .stream()
			        .allMatch((s) -> s.startsWith("a"));
			 
		System.out.println(allStartsWithA);      // false
			 
		boolean noneStartsWithZ = 
			    stringCollection
			        .stream()
			        .noneMatch((s) -> s.startsWith("z"));
			 
		System.out.println(noneStartsWithZ);      // true
			//Count
		long startsWithB = 
			    stringCollection
			        .stream()
			        .filter((s) -> s.startsWith("b"))
			        .count();
				 
		System.out.println(startsWithB);    // 3
		//Reduce
		Optional<String> reduced =
			    stringCollection
			    	.stream()
			        .sorted()
					.reduce((s1, s2) -> s1 + "#" + s2);
					 
		reduced.ifPresent(System.out::println);
		
	}
	
	public static void main(String[] args) {
		//defInterFace();
		//mySort();
		//LambdaM();
		//new Excute().lambdaN();
		//callStreams();
		
		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint);                   // null
		/* 
		Hints hints1 = Person.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2
		 */
		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);    
	}

}
