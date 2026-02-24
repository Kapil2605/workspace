package com.interview;

public class swapTwoNumber {

	public static void main(String[] args) {
		int a=10;
		int b=20;
//		int temp=a;
//		a=b;
//		b=temp;
		 
		//System.out.println(a+" "+b); 
		
		a^=b;
		System.out.println(a+" "+b);
		b^=a;
		System.out.println(a+" "+b);
		a^=b;
		System.out.println(a+" "+b);
		
	}

}
