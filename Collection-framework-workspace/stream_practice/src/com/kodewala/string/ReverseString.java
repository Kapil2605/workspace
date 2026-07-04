package com.kodewala.string;

import java.util.*;

public class ReverseString {
	public static void main(String[] args) {

		List<String> list = Arrays.asList("Java", "Python", "Spring");
		
		list.stream().map(str->new StringBuilder(str).reverse().toString()).forEach(System.out::println);
		
	}
}
