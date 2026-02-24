package com.set;

import java.util.HashSet;

public class SameHashCode {

	public static void main(String[] args) {
		String s1 = "FB";
        String s2 = "Ea";
        

        System.out.println(s1.equals(s2));     // false
        System.out.println(s1.hashCode());     // 2236
        System.out.println(s2.hashCode());     // 2236
        
        HashSet<String>set=new HashSet<>();
        set.add(s1);
        set.add(s2);
        
        for(String s:set) {
        	System.out.println(s);
        }
	}

}
