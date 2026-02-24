package com.practice.Advancedlevel;

import java.util.Arrays;
import java.util.Comparator;

public class FiindLongestWord {
	public static void main(String[] args) {
		String sentence = "java stream api makes coding enjoyable";

		String longestWord =
			    Arrays.stream(sentence.split("\\s+"))
			          .max(Comparator.comparingInt(String::length))
			          .orElse(null);

			System.out.println(longestWord);

	}
}
