package com.java8.practice;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}
		map.forEach((id, val) -> System.out.println(val));
		System.out.println("----------------------------"); 
		
		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3));            

		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9));    

		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));  
		System.out.println(map.get(23)); 

		map.computeIfAbsent(300, num -> "bam");
		System.out.println(map.get(300)); 

	}

}
