package com.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicates {
	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,4,2,5,4,6);
		
		list.stream().distinct().forEach(System.out::println);
		
	}
}
