package com.practice.Intermidiatelevel;

import java.util.*;
import java.util.stream.Collectors;

public class FindingDuplicateElements {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
		Set<Integer> seen = new HashSet<>();
		Set<Integer> duplicates = list.stream().filter(n->!seen.add(n)).collect(Collectors.toSet());
		System.out.println(duplicates);

	}

}
