package com.practice.Intermidiatelevel;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingEvenOdd {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Map<String, List<Integer>> result =list.stream().collect(Collectors.groupingBy(n->n%2==0?"Even":"Odd"));
		System.out.println(result);

	}

}
