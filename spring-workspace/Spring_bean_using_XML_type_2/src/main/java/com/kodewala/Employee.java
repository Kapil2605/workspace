package com.kodewala;

public class Employee {
	private String name;
	private int id;
	private String dept;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void display() {
		System.out.println("Name: "+name+" Id: "+id+" Dept: "+dept);
	}
}
