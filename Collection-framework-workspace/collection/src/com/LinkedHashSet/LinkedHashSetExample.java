package com.LinkedHashSet;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {

	public static void main(String[] args) {
		LinkedHashSet<String>linkedHashSet=new LinkedHashSet<String>();
		linkedHashSet.add("BLR");
		System.out.println("BLR".hashCode());
		
		linkedHashSet.add("CHE");
		System.out.println("CHE".hashCode());
		
		linkedHashSet.add("HYD");
		System.out.println("HYD".hashCode());
		
		linkedHashSet.add("MUM");
		System.out.println("MUM".hashCode());
		
		linkedHashSet.add("BLR");
		
		System.out.println(linkedHashSet);
	}

}
