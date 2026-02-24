package com.practice.Intermidiatelevel;

import java.util.*;
import java.util.stream.Collectors;

public class PartitioningByExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Map<Boolean,List<Integer>>result=list.stream().collect(Collectors.partitioningBy(n->n%2==0));
		System.out.println("Even No:" +result.get(true));
		System.out.println("Odd No:" +result.get(false));

	}

}
