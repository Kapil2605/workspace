package com.list;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		ArrayList<String>arr=new ArrayList<String>();
		arr.add("BLR");
		arr.add("CHE");
		arr.add("HYD");
		arr.add("PTN");
		System.out.println(arr);
		
		arr.add(1, "DEL");
		System.out.println(arr);
		
		arr.remove(0);
		System.out.println(arr);
		
	}

}