package com.LinkedHashSet;

import java.util.TreeSet;

class Employee implements Comparable{
	String name;
	
	Employee(String _name){
		this.name=_name;
	}
	@Override
	public int compareTo(Object obj) {
		Employee acc=(Employee)obj;
		return this.name.compareTo(acc.name);
	}
}



public class TreeHashSetExample {

	public static void main(String[] args) {
		Employee e1=new Employee("Kapil");
		Employee e2=new Employee("Gaurav");
		Employee e3=new Employee("Kapil");
		Employee e4=new Employee("Aman");

		TreeSet<Employee>set=new TreeSet<>();
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		
		for(Employee e:set) {
			System.out.println(e.name);
		}
	}

}
