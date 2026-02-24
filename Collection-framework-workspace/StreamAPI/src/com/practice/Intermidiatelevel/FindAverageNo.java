package com.practice.Intermidiatelevel;

import java.util.*;

public class FindAverageNo {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(1,2,3,4,5,6,7);
		long size=list.stream().count();
		long sum=list.stream().mapToInt(n->n).sum();
		System.out.println(sum/size);
	}

}
