package com.array;

import java.util.Arrays;
import java.util.List;

public class SumOfNum {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,4);
		
		//sum of numbers
		System.out.println(list.stream().reduce(0,(a,b)->a+b));
		
		//product of number
		System.out.println(list.stream().reduce((a,b)->a*b));

	}
}
