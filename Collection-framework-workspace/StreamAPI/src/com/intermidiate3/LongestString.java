package com.intermidiate3;

import java.util.*;

public class LongestString {
    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("Java", "SpringBoot", "Microservices", "API");

        String longest =
                list.stream()
                    .max(Comparator.comparingInt(String::length))
                    .orElse(null);

        System.out.println(longest);
        
        String str=list.stream().sorted((a,b)->b.length()-a.length()).findFirst().get();
        System.out.println(str);
    }
}
