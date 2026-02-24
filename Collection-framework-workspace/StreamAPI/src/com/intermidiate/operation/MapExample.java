package com.intermidiate.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapExample {
	public static void main(String[] args) {
		List<String>list=Arrays.asList("Kodewala","Academy","Java");
		
		List<Integer> lengths = list.stream()
                .map(e -> e.length())
                .toList();   // Java 16+

		lengths.forEach(System.out::println);

		
	}
}
