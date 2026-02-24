package com.set;

import java.util.HashSet;

class Customer{
	String name;
	String customerCode;
	
	
	public Customer(String name, String customerCode ) {
		super();
		this.name = name;
		this.customerCode = customerCode;
	}

	@Override
	public boolean equals(Object obj) {
		Customer c2=(Customer) obj;
		return this.name.equals(c2.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
public class HashCodeAndEqualsExample {

	public static void main(String[] args) {
		
		Customer c1=new Customer("Kapil","KA001");
		Customer c2=new Customer("Kapil","KA002");
		Customer c3=new Customer("Gaurav","KA003");
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2));
		
		HashSet<Customer>customers=new HashSet<>();
		
		
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		for(Customer c:customers) {
			System.out.println(c.name+" "+c.customerCode);
		}
		
	}

}

