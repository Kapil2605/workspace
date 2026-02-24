package com.set.questions;

public class OverloadingExample {
//	int  display(int... x) {
//		return 100;
//	}
	int display(Long x) {
		return 200;
	}
//	int display(long x) {
//		return 100;
//	}
	public static void main(String[] args) {
		OverloadingExample s= new OverloadingExample();
//		System.out.println(s.display(0));
		System.out.println(s.display(1000L));
		
	}
}
