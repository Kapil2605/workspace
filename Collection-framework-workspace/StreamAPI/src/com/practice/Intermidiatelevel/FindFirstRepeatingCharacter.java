package com.practice.Intermidiatelevel;

public class FindFirstRepeatingCharacter {

	public static void main(String[] args) {
		String name="swiss";
		
		Character firstNonRepeated=name.chars().mapToObj(c->(char)c)
				.filter(ch->name.indexOf(ch)!=name.lastIndexOf(ch)).findFirst().orElse(null);
		
		System.out.println(firstNonRepeated);
	}

}
