package com.java8.practice;

import java.util.Arrays;

@FunctionalInterface
public interface FunctionalInterfaceExample<F, T> {
	 T convert(F from);
	 
	 static  void convertImpl(){
		 FunctionalInterfaceExample<String, String[]> converter = (from) -> checkFormData(from);
		 String[] converted = converter.convert("123 454 090 632973");
		 Arrays.asList(converted).forEach(e->System.out.println(e));;
	 }
	 
	 static String[] checkFormData(String str){
		 return str.split(" ");
		 
	 }

}
