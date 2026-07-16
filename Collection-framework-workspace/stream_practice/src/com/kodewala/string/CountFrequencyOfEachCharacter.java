package com.kodewala.string;

import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequencyOfEachCharacter {

	public static void main(String[] args) {
		String str="banana";
		
		Map<Character,Long>result=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(result);
	}

}
