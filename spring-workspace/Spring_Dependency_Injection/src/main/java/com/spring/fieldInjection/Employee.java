package com.spring.fieldInjection;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	@Autowired
	private Address address;
	
	public void showDetails() {
		System.out.println("Village: " + address.villageName);
        System.out.println("City: " + address.city);
        System.out.println("Country: " + address.country);
	}
	
}
