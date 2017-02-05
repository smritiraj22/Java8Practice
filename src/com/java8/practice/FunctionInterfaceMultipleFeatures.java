package com.java8.practice;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface FunctionInterfaceMultipleFeatures<F, U, T> {
	T converter(F from, U other);

	static void convertImpl() {
		FunctionInterfaceMultipleFeatures<String, String, List<String>> converter = (from, other) -> {
			return checkFormData(from, other);
		};
		List<String> converted = converter.converter("123 454 090 632973", "abc");
		Arrays.asList(converted).forEach(e -> System.out.println(e));
	}

	static List<String> checkFormData(String str, String other) {
		System.out.println(other);
		String[] converted = str.split(" ");
		List<String> l = Arrays.asList(converted);
		l.replaceAll(e -> e=((String) e+other));
		return l;

	}

}
