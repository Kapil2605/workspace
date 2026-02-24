package com.practice.Intermidiatelevel;

import java.util.*;
import java.util.stream.Collectors;

public class SortListOfStrings {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("java", "python", "java", "c++", "python", "go");
		
		List<String>result=list.stream().sorted((a,b)->a.length()-b.length()).collect(Collectors.toList());
		System.out.println(result);

	}

}
