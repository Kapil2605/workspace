package com.interview;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		System.out.println(a%2==0 ?"even":"odd");
		
		int b=sc.nextInt();
		System.out.println(a>b ? "a is greater than b":"b is greater than a");
		
		
	}

}
