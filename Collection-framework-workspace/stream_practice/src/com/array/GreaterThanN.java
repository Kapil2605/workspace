package com.array;

import java.util.List;

public class GreaterThanN {

	public static void main(String[] args) {
		List<Integer>list=List.of(1,2,3,4,5,6);
		int N=3;
		System.out.println("greater than n");
		list.stream().filter(n->n>N).forEach(n->System.out.println(n));
		
		System.out.println("Less than n");
		list.stream().filter(n->n<N).forEach(n->System.out.println(n));

	}

}
