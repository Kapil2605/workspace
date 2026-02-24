package com.interview;

import java.util.Scanner;

public class LeapYearCheck {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
		
		//leap year not divisible by 4 not divisible by 100 not divisible 400
		
		boolean leap=(year%400==0)||(year%4==0 &&year%100!=0);
		System.out.println(leap?"leap year":"not leap year");
	}

}
