package com.interview;

public class ArmstrongNo {

	public static void main(String[] args) {
		int number=371,originalNumber,reminder,result=0;
		
		originalNumber=number;
		
		while(originalNumber!=0) {
			reminder=originalNumber%10;
			result+=Math.pow(reminder, 3);
			originalNumber/=10;
		}
		if(result==number) {
			System.out.println(number+" is a armstrong number");
		}else {
			System.out.println(number+" is not a armstrong number");
		}
	
	}

}
