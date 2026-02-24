package com.LinkedList;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		LinkedList<String>list=new LinkedList<>();
		list.add("BLR");
		list.add("HYD");
		list.add("Delhi");
		list.add("CHE");
		
		System.out.println(list);
		
		list.add(0,"AHM");
		
		System.out.println(list);
	}

}
