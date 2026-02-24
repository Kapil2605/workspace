package com.practice.Intermidiatelevel;

import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("java", "python", "go", "spring");
		Map<String,Integer>result=list.stream().collect(Collectors.toMap(s->s,s->s.length()));
		
		System.out.println(result);
	}

}
