package com.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountDuplicate {
	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,4,2,5,4,6);
		
		System.out.println(list.stream().distinct().filter(n->Collections.frequency(list, n)>1).count());
		
	}
}
