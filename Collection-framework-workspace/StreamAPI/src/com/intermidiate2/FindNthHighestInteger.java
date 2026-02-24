package com.intermidiate2;

import java.util.List;

public class FindNthHighestInteger {

	public static void main(String[] args) {
		List<Integer>list=List.of(23,46,67,25,78,45);
		
		//find the 3rd higest integer in list
		int highest=list.stream().distinct().sorted((a,b)->b-a).skip(2).findFirst().get();
		System.out.println(highest);
		int lowest=list.stream().distinct().sorted((a,b)->a-b).skip(0).findFirst().get();
		System.out.println(lowest);
	}

}
