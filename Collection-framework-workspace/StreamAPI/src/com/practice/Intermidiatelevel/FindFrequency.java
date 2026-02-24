package com.practice.Intermidiatelevel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFrequency {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,2,3,4,5,3,4,5,6,7);
		Map<Integer,Long>result=list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
		System.out.println(result);
	}

}
