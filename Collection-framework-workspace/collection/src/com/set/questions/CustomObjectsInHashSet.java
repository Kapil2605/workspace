package com.set.questions;

import java.util.HashSet;

class Employee{
	String name;
	
	Employee(String _name){
		this.name=_name;
	}
	
	@Override
	public int hashCode() {
		return 100;
	}
}
public class CustomObjectsInHashSet {

	public static void main(String[] args) {
		Employee e1=new Employee("Kapil");
		Employee e2=new Employee("Yadav");
		Employee e3=new Employee("khola");
		Employee e4=new Employee("Anish");
		Employee e5=new Employee("Gaurav");
		
		System.out.println(e1.equals(e2)+" "+(e1.hashCode()==e2.hashCode()));
		
		HashSet<Employee>set=new HashSet<>();
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		System.out.println(set.size());
		
		
		
	}

}
