package com.array;

import java.util.List;
import java.util.stream.Stream;

public class EvenOdd {

	public static void main(String[] args) {
		List<Integer>list=List.of(1,2,3,4,5,6);
		
		Stream<Integer>stream=list.stream();
		
		list.stream().filter(n->n%2!=0).forEach(n->System.out.println(n));

	}

}
