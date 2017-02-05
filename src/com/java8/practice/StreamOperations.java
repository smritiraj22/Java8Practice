package com.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		IntStream.range(1, 4).forEach(System.out::println);

		myList.stream().filter(s -> !s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		Arrays.stream(new int[] { 1, 2, 3 }).map(n -> 2 * n + 1).forEach(System.out::println);

		Arrays.stream(new int[] { 1, 2, 3 }).map(n -> 2 * n + 1).average().ifPresent(System.out::println);

		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			if (s.startsWith("b"))
				return true;
			else
				return false;
		}).forEach(s -> System.out.println("forEach: " + s));

		Stream.of("d2", "a2", "b1", "b3", "c").sorted((s1, s2) -> {
			System.out.printf("sort: %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));
		
		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(s -> {
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return true;
		}).map(s -> {
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		}).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	}

}
