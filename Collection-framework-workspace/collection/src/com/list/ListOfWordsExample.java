package com.list;

import java.util.ArrayList;
import java.util.List;

public class ListOfWordsExample {

	public static void main(String[] args) {
		List<String>word=new ArrayList<>();
		word.add("Ahemdabad");
		word.add("Mumbai");
		word.add("Allahbad");
		
		for(String s:word) {
//			if(s.startsWith("A")) {
//				System.out.println(s);
//			}
			if("A".startsWith(s)) {
				System.out.println(s);
			}
		}
	}

}
