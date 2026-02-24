package com.practice.Easylevel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Filter all strings starting with a vowel

public class StringStartingWithVowel {

	public static void main(String[] args) {
		List<String>list=Arrays.asList("Kapil","Anish","Guddu","Oak");
		
		list.stream()
	    .filter(s -> {
	        char ch = Character.toLowerCase(s.charAt(0));
	        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
	    })
	    .forEach(System.out::println);

	}

}
