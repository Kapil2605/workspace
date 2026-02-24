package com.practice.Easylevel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseExample {

	public static void main(String[] args) {
		List<String>list=Arrays.asList("apple","banana","orange");
		 List<String> result = list.stream()
	                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
	                .collect(Collectors.toList());

	        System.out.println(result);
	        
	        
	       List<String>result2=list.stream().limit(1).map(e->e.toUpperCase()).collect(Collectors.toList());
	       System.out.println(result2);
	}

}
