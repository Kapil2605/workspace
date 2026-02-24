package com.practice.Advancedlevel;

import java.util.*;
import java.util.stream.Collectors;

public class SortMap {

	public static void main(String[] args) {
		Map<String,Integer>mp=new HashMap<>();
		mp.put("Kapil", 2);
		mp.put("Yadav", 5);
		mp.put("Khola", 4);
		mp.put("Aprings", 3);
		mp.put("Python", 6);
		
		Map<String, Integer> sortedMap =
			    mp.entrySet()
			       .stream()
			       .sorted(Map.Entry.comparingByKey())
			       .collect(Collectors.toMap(
			           Map.Entry::getKey,
			           Map.Entry::getValue,
			           (a, b) -> a,
			           LinkedHashMap::new
			       ));

			System.out.println(sortedMap);

	}

}
