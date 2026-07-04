package com.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseList {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        IntStream.range(0, list.size())
                 .mapToObj(i -> list.get(list.size() - 1 - i))
                 .forEach(System.out::println);
	}
}
