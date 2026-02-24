package com.kapil.demo.MySpringApp;

public class Student {

    private int id;
    private String name;

    public Student() {
        System.out.println("Student object created");
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }

    // setters (for DI)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
