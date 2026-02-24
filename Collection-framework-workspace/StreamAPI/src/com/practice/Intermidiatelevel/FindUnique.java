package com.practice.Intermidiatelevel;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

public class FindUnique {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(3,1,2,3,4,5,2,3,4,6);
		
		
		//Using set 
		Set<Integer>seen=new HashSet<>();
		Set<Integer>duplicates=new HashSet<>();
		
		list.forEach(n -> {
		    if (!seen.add(n)) {
		        duplicates.add(n);
		    }
		});

		Set<Integer>unique=seen.stream().filter(n->!duplicates.contains(n)).collect(Collectors.toSet());
		System.out.println(unique);
		
		
		//Using map
		List<Integer>result=list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()))
				.entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(result);
		
		
		//using frequency
		list.stream()
	    .filter(n -> Collections.frequency(list, n) == 1)
	    .forEach(System.out::println);

	}

}
