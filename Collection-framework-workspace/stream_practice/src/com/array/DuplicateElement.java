package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElement {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,4,2,5,4,6);
		
		Set<Integer>s=new HashSet<>();

		list.stream().filter(n->s.add(n)).forEach(System.out::println);
	}

}
