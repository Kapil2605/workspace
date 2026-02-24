package com.list;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<Integer>arr=new ArrayList<>();
		for(int i=0;i<=10;i++) {
			arr.add(i);
		}
		
		for(Integer i:arr) {
			System.out.print(i+" ");
		}
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)%2==0) {
				arr.remove(i);
			}
		}
		System.out.println("after removing even");
		System.out.println(arr);
	}

}
