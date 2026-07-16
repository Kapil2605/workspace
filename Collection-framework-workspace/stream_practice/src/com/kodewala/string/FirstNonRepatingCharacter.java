package com.kodewala.string;

public class FirstNonRepatingCharacter {

	public static void main(String[] args) {
		String str="HelloH";
		
		Character charac=str.chars().mapToObj(c->(char)c).filter(ch->str.indexOf(ch)==str.lastIndexOf(ch)).findFirst().orElse(null);
		
		System.out.println(charac);
	}

}
