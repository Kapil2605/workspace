package com.intermidiate.operation;

import java.util.stream.Stream;

public class NameSpliting {

	public static void main(String[] args) {
		String str="Gaurav";
		Stream<Character>letters=str.chars().mapToObj(c->(char)c);
		letters.forEach(c->System.out.println(c));
	}

}
