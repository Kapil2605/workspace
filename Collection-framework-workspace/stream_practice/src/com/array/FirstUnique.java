package com.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstUnique {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(2,3,4,2,5,4,6);
		
		Set<Integer>set=new HashSet<>();
		
		Integer first= list.stream().filter(n->Collections.frequency(list, n)==1).findFirst().get();
		System.out.println(first);
		
		Integer last= list.stream().filter(n->Collections.frequency(list, n)==1).sorted((a,b)->b-a).findFirst().get();
		System.out.println(last);
	}
}
