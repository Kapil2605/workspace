package com.set.questions;

import java.util.HashSet;

public class BucketIndexExample {
	String name;
	
	public BucketIndexExample(String name) {
		super();
		this.name = name;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		BucketIndexExample s=(BucketIndexExample)obj;
		return this.name.equals(s.name);
	}
	
	
	
	public static void main(String[] args) {
		HashSet<String>set=new HashSet<String>();
		
		set.add("Bengalore");
		set.add("Hyderabad");
		set.add("Chennai");
		set.add("Delhi");
		set.add("Hyderabad");
		
		for(String s:set) {
			 int hashCode = s.hashCode();
	            int bucketIndex=(16-1)&hashCode;
	            System.out.println("Bucket index "+bucketIndex);
				/*
				 *  int hash = hashCode ^ (hashCode >>> 16);
				 * int bucketIndex=(16 - 1) & hash;
				 * System.out.println("Bucket index: "+bucketIndex);
				 */
		}
		System.out.println(set);
	}

}
