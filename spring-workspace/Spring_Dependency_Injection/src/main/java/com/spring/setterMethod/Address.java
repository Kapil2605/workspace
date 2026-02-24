package com.spring.setterMethod;

public class Address {
	private String city;
	private String state;
	
	Address(String city,String state){
		this.city=city;
		this.state=state;
	}
	
	public String toString(){
		return city+" "+state;
	}
}
