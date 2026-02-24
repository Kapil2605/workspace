package com.spring.setterMethod;

public class Employee {
	private String id;
	private String name;
	private Address address;
	
	Employee(){
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void display() {
		System.out.println(id+" "+name);
		System.out.println("Address...."+address);
	}
	
	
}
