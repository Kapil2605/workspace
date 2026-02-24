package com.list;

import java.util.ArrayList;

public class ReverseArrayList {
	static void swap(ArrayList<Integer>arr,int start,int end) {
		int temp=arr.get(start);
		arr.set(start, arr.get(end));
		arr.set(end, temp);
	}
	public static void main(String[] args) {
		ArrayList<Integer>arr=new ArrayList<Integer>();
		for(int i=1;i<=10;i++) {
			arr.add(i);
		}
		int start=0;
		int end=arr.size()-1;
		while(start<end) {
			swap(arr,start,end);
			start++;
			end--;
		}
		
		for(Integer num:arr) {
			System.out.print(num+" ");
		}
	}

}
