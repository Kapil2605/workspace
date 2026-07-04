package com.array;

import java.util.*;
import java.util.stream.Collectors;

public class PartitionEvenAndOdd {
	public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Boolean, List<Integer>> map = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(map);
    }
}
