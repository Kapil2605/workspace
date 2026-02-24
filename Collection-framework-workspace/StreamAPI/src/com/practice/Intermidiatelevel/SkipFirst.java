package com.practice.Intermidiatelevel;

import java.util.*;

public class SkipFirst {

	public static void main(String[] args) {
		List<String> list =Arrays.asList("java", null, "python", null, "go", "spring");
		list.stream().skip(2).forEach(System.out::print);

	}

}
