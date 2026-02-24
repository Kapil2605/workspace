package com.practice.Intermidiatelevel;

import java.util.*;

public class CountEvenOdd {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 10);
		long even=list.stream().filter(n->n%2==0).count();
		System.out.println("even: "+even);
		
		long odd=list.stream().filter(n->n%2!=0).count();
		System.out.println("odd: "+odd);
	}

}
