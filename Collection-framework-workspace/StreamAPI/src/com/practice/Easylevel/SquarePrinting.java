package com.practice.Easylevel;

import java.util.Arrays;
import java.util.List;

//Convert a list of integers into their squares

public class SquarePrinting {
	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,4,5);
		
		list.stream().map(n->n*n).forEach(e->System.out.println(e));
	}
}
