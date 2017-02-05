package com.java8.practice;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InBuiltFIExamples {
	public static Predicate<String> predicate = (s) -> s.length() > 0;
	
	public static Function<String,Integer> toInteger = Integer::parseInt;
	
	static Supplier<InBuiltFIExamples> supp = InBuiltFIExamples::new;
	
	static Optional<String> optional = Optional.of("smriti");

	public static void main(String[] args) {
		System.out.println(predicate.test(""));
		System.out.println(predicate.test("  "));
		System.out.println(toInteger.apply("1234"));
		System.out.println(supp.get().sayHello());
		optional.ifPresent((s) -> System.out.println(s));
	}

	public String sayHello(){
		return "Hello";
	}
}
