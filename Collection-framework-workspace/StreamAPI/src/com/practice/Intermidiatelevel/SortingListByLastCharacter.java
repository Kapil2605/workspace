package com.practice.Intermidiatelevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingListByLastCharacter {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("java", "python", "java", "c++", "python", "go");
		
		List<String>result=list.stream().sorted(Comparator.comparing(s->s.charAt(s.length()-1))).collect(Collectors.toList());
		System.out.println(result);

	}

}
