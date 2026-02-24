package com.set;

import java.util.HashSet;
class Student{
	String name;
	
	Student(String name){
		this.name=name;
	}

	public Student(Student s1) {
		this.name=s1.name;
	}
	
	@Override
	public boolean  equals(Object obj) {
		Student s=(Student)obj;
		return this.name.equals(s.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
}
public class SetExample {

	public static void main(String[] args) {
		Student s1=new Student("Kapil");
		Student s2=new Student("Yadav");
		Student s3=s1;
		Student s4=new Student(s1);
		
		
		
		HashSet<Student>set=new HashSet<>();
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		
		
		System.out.println(s1.equals(s3));
		System.out.println(s1.hashCode()+" "+s3.hashCode());
		System.out.println("............");
		System.out.println(s1.equals(s4));
		System.out.println(s1.name+" "+s4.name);
		System.out.println(s1.hashCode()+" "+s4.hashCode());
		
//		for(Student s:set) {
//			System.out.println(s.name);
//		}
	}

}
