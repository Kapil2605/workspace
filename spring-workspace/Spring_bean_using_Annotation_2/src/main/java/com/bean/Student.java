package com.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Value("Kapil")
	public String name;
	
	@Value("12")
	public int rollNo;
	
	@Value("10th")
	public String classStandard;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getClassStandard() {
		return classStandard;
	}
	public void setClassStandard(String classStandard) {
		this.classStandard = classStandard;
	}
	
	
	public void display() {
		System.out.println("Name: "+name+" roll No: "+rollNo+" class: "+classStandard);
	}
	
	
}
