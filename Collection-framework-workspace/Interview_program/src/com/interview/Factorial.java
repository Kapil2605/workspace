package com.interview;

public class Factorial {

	public static void main(String[] args) {
		int a=5;
		int factorial=1;
		for(int i=a;i>0;i--) {
			factorial=factorial*i;
			System.out.println(factorial);
		}
	}

}
