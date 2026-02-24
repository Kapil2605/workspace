package com.list;

import java.util.ArrayList;

public class LargestAndSmallest {

	

	public static void main(String[] args) {
		ArrayList<Integer>arr=new ArrayList<>();
		
		arr.add(12);
		arr.add(13);
		arr.add(14);
		arr.add(17);
		arr.add(-11);
		
		int max=0;
		int min=0;
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)>max) {
				max=arr.get(i);
			}
			else if(arr.get(i)<min) {
				min=arr.get(i);
			}
		}
		
		System.out.println("maximum: "+max);
		System.out.println("minimum: "+min);

	}

}
