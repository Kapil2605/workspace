package com.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private int rollNo;
	private String name;
	
	@Autowired
	private Address address;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address _address) {
		this.address = _address;
	}
	@Override
	public String toString() {
		return "Roll No: "+rollNo+" Name: "+name;
	}
}
