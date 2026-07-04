package com.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFrequency {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4,2,3, 5);

		Map<Object, Long>mp=list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
		System.out.println(mp);
	}
}
