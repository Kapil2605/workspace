package com.interview;

public class ReverseNumber {

	public static void main(String[] args) {
		int num=434;
		int t=num;
		int rev=0;
		while(num!=0) {
			rev=rev*10+num%10;
			num/=10;
		}
		System.out.println(num+" "+rev);
		System.out.println(t==rev?"palindrome":"not palindrome");
	}

}
