package com.java8.practice;

public interface DefaultChecker {
	double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
    
    default double power(int a, int b){
    	return Math.pow(a, b);
    }

}
