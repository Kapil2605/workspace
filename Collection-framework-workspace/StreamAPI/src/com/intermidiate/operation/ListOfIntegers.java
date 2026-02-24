package com.intermidiate.operation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOfIntegers {

	public static void main(String[] args) {
		List<Integer>list=List.of(1,2,3,4,4,5);
		
		Set<Integer> seen = new HashSet<>();
		
		Set<Integer>output=list.stream().filter(s->!seen.add(s)).collect(Collectors.toSet());
		System.out.println(output);

	}

}
