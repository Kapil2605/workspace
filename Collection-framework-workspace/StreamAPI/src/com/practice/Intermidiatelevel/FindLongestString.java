package com.practice.Intermidiatelevel;

import java.util.*;

public class FindLongestString {

	public static void main(String[] args) {
		
		//Longest String in the list
		List<String> list =Arrays.asList("java", "python", "java", "c++", "python", "go");
		String resultingString=list.stream().sorted((a,b)->b.length()-a.length()).findFirst().get();
		System.out.println(resultingString);
		
		//Shortest String in the list
		List<String> shortest =Arrays.asList("java", "python", "java", "c++", "python", "go");
		String shortestString=list.stream().sorted((a,b)->a.length()-b.length()).findFirst().get();
		System.out.println(shortestString);
		
	}

}
