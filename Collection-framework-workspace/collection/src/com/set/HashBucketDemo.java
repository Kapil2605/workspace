package com.set;

import java.util.*;

class Students {
    String name;

    Students(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 100; // 🔥 force same hashCode to create collision
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student s = (Student) obj;
        return name.equals(s.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class HashBucketDemo {

    // Method to calculate bucket index like HashMap
    static int getBucketIndex(int hashCode, int capacity) {
        int hash = hashCode ^ (hashCode >>> 16);
        return (capacity - 1) & hash;
    }

    public static void main(String[] args) {

        int capacity = 16; // default HashMap capacity

        Students s1 = new Students("Kapil");
        Students s2 = new Students("Yadav");
        Students s3 = new Students("Aman");

        Students[] students = { s1, s2, s3 };

        Map<Integer, List<Students>> bucketTable = new HashMap<>();

        for (Students s : students) {

            int hashCode = s.hashCode();
            int hash = hashCode ^ (hashCode >>> 16);
            int bucketIndex = getBucketIndex(hashCode, capacity);

            System.out.println("Object : " + s);
            System.out.println("hashCode : " + hashCode);
            System.out.println("mixedHash : " + hash);
            System.out.println("bucketIndex : " + bucketIndex);
            System.out.println("--------------------------------");

            bucketTable
                .computeIfAbsent(bucketIndex, k -> new ArrayList<>())
                .add(s);
        }

        System.out.println("\n🔹 Bucket Storage (Collision Handling)");
        for (Map.Entry<Integer, List<Students>> entry : bucketTable.entrySet()) {
            System.out.println("Bucket " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
