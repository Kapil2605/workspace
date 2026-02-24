package com.springDemo;

public class Employee {

    private String firstName;
    private String lastName;
    private String email;

    public Employee() {
        System.out.println("Employee object created");
        System.out.println("Employee  created");
    }

    // ✅ MUST BE PUBLIC
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void show() {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
    }
}
