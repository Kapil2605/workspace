package com.practice.Advancedlevel;

import java.util.*;
import java.util.stream.Collectors;

public class FindWordFrequency {

	public static void main(String[] args) {
		String sentence = "java is fun and java is powerful";
		
		Map<String,Long>result=Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(n->n,Collectors.counting()));
		System.out.println(result);
	}

}
