package com.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondHightestNumber {
	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(2,3,4,2,5,4,6);
		
		//second hightest
		System.out.print(list.stream().distinct().sorted((a,b)->b-a).skip(1).findFirst().get());
		
		//second smallest
		System.out.print(list.stream().distinct().sorted().skip(1).findFirst().get());
	}
}
