package com.springcore;

public class Student {

    private int studentId;
    private String studentName;
    private String studentAddress;

    // Setter methods (Required for Setter DI)
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public void display() {
        System.out.println("Student Id      : " + studentId);
        System.out.println("Student Name    : " + studentName);
        System.out.println("Student Address : " + studentAddress);
    }
}
