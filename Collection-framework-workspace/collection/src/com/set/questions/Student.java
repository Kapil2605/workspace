package com.set.questions;

import java.util.HashSet;

public class Student {
	
	int id;
	String name;
	Student(int _id,String _name){
		this.id=_id;
		this.name=_name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student s=(Student)obj;
		 return this.id == s.id && this.name.equals(s.name);
	}
	

	public static void main(String[] args) {
		Student s1 = new Student(1, "A");
		Student s2 = new Student(1, "A");

		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() == s2.hashCode());
		
		HashSet<Student>set=new HashSet<>();
		set.add(s1);
		set.add(s2);
		
		System.out.println(set);
	}

}
