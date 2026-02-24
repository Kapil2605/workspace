package com.list;

import java.util.ArrayList;

public class RemoveDuplicates {

	public static void main(String[] args) {
		ArrayList<Integer>arr=new ArrayList<>();
		arr.add(12);
		arr.add(13);
		arr.add(13);
		arr.add(14);
		arr.add(13);
		arr.add(12);
		
		ArrayList<Integer> unique = new ArrayList<>();

		
		for(int i=0;i<arr.size();i++) {
			if(!unique.contains(arr.get(i))) {
				unique.add(arr.get(i));
			}
		}
		System.out.println(unique);
	}

}
