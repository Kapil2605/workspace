package com.practice.Intermidiatelevel;

import java.util.Arrays;
import java.util.*;

public class Findsecondhighestnumber {

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(12,1,3,1,4,5,15,16,19,35,14);
		int number=list.stream().distinct().sorted((a,b)->b-a).skip(1).findFirst().get();
		System.out.println(number);

	}

}
