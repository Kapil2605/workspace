package com.intermidiate.operation;

import java.util.List;

public class LengthGreaterAndtoUpperCase {

	public static void main(String[] args) {
		List<String>words=List.of("Kapil","Yadav","Anuj","AA");
		
		List<String>output=words.stream().filter(s->s.length()>3).map(e->e.toUpperCase()).toList();
		
		System.out.println(output);
	}

}
