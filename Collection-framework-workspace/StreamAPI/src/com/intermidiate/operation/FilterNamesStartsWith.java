package com.intermidiate.operation;

import java.util.List;

public class FilterNamesStartsWith {

	public static void main(String[] args) {
		List<String>words=List.of("Kapil","Yadav","Anuj","AA","1234");
		
		List<String>output=words.stream().filter(s->s.length()>3).toList();
		
		System.out.println(output);
		
		
	}

}
