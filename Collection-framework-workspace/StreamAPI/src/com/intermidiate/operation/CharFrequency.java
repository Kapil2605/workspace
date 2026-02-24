package com.intermidiate.operation;

import java.util.Map;
import java.util.stream.Collectors;

public class CharFrequency {
    public static void main(String[] args) {
        String str = "programming";

        Map<Character, Long> freqMap =
                str.chars()
                   .mapToObj(c -> (char) c)
                   .collect(Collectors.groupingBy(
                       c -> c,
                       Collectors.counting()
                   ));

        System.out.println(freqMap);
    }
}
