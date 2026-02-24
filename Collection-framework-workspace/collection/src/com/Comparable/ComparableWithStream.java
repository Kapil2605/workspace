package com.Comparable;

import java.util.*;
import java.util.stream.*;

class Studnt implements Comparable<Studnt> {

    int age;
    String name;

    Studnt(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Studnt s) {
        // Natural sorting: age ascending
        return this.age - s.age;
    }

    @Override
    public String toString() {
        return age + " - " + name;
    }
}

public class ComparableWithStream {

    public static void main(String[] args) {

        List<Studnt> list = Arrays.asList(
                new Studnt(23, "Kapil"),
                new Studnt(21, "Aman"),
                new Studnt(25, "Rohit"),
                new Studnt(22, "Neha")
        );

        System.out.println("Sorted using Stream (Comparable):");

        list.stream()
            .sorted()   // uses compareTo()
            .forEach(System.out::println);
    }
}
