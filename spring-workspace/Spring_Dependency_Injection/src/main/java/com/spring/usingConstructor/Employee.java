package com.spring.usingConstructor;

public class Employee {
	String id;
	String name;
	Address address;
	
	Employee(String _id,String _name,Address _address){
		this.id=_id;
		this.name=_name;
		this.address=_address;
	}
	public void display() {
		System.out.println(id+" "+name);
		System.out.println("Address: "+address);
	}
}
