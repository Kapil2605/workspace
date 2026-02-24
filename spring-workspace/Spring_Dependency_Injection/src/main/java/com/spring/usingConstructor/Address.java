package com.spring.usingConstructor;

public class Address {
	
	String city;
	String country;
	
	Address(String _city,String _country){
		this.city=_city;
		this.country=_country;
	}
	
	public String toString() {
		return city+ " "+country;
	}
	
}
