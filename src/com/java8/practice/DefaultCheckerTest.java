package com.java8.practice;

public class DefaultCheckerTest {

	public static void main(String[] args) {
		DefaultChecker checker = new DefaultChecker() {
		    @Override
		    public double calculate(int a) {
		        return (sqrt(a * 100)+power(a, 2));
		    }
		};

		System.out.println(checker.calculate(100));     
		System.out.println(checker.sqrt(16)); 
		System.out.println(checker.power(16,2)); 
		FunctionalInterfaceExample.convertImpl();
		FunctionInterfaceMultipleFeatures.convertImpl();

	}

}
