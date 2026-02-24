package com.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String>map=new HashMap<>();
		
		map.put("Karnataka","BLR");
		map.put("Telangana","HYD");
		map.put("Maharastra","MUM");
		map.put("New Delhi","DEL");
		map.put("KArnataka","BLR"); 
		
		
		Set<Entry<String,String>>entrySet=map.entrySet();
		Iterator<Entry<String,String>>itr=entrySet.iterator();
		
		while(itr.hasNext()){
			Entry<String,String>entry=itr.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

}
