package com.set;

public class PracFinal {
	int display() {
		try {
			return 10;
		}catch(Exception e) {
			return 20;
		}finally {
			return 100;
		}
		
	}
	public static void main(String[] args) {
		try {
			int a=10;
			int b=0;
			System.out.println(a/b);
		}finally {
			String s=null;
			System.out.println(s.length());
		}
	}

}
