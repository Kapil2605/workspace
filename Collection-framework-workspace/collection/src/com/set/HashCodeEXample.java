package com.set;
class Employee{
	String firstName;
	String lastName;
	
	
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object obj) {
		Employee p2=(Employee) obj;
		return this.firstName.equals(p2.firstName) && this.lastName.equals(p2.lastName);
	}
	
	@Override
	public int hashCode() {
		return firstName.hashCode() + lastName.hashCode();
	}
}
public class HashCodeEXample {

	public static void main(String[] args) {
		
		Employee p1=new Employee("Kapil","Yadav");
		Employee p2=new Employee("Kapil","Yadav");
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p1.equals(p2));
		
		
	}

}
