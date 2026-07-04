package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FirstDuplicate {
	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,4,2,5,4,6);
		
		Set<Integer>set=new HashSet<>();
		
		Integer result= list.stream().filter(n->!set.add(n)).findFirst().get();
		System.out.println(result);
		
		//last
		Integer resultlast= list.stream().filter(n->!set.add(n)).sorted((a,b)->b-a).findFirst().get();
		System.out.println(resultlast);
	}
}
