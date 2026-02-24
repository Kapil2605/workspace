package com.practice.Intermidiatelevel;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNull {

	public static void main(String[] args) {
		List<String>list=Arrays.asList("Java","Spring","Go",".Net",null,null);
		List<String> result =
			    list.stream()
			        .filter(Objects::nonNull)
			        .collect(Collectors.toList());

			System.out.println(result);

	}

}
