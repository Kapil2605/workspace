package com.set.questions;

class Animal{
	String name;
	int method() {
		return 5;	
	}
}

class Dog extends Animal{
	String id;
	@Override
	int method() {
		return 10;
	}
}
public class UpcastingDownCastingExample {

	public static void main(String[] args) {
		
		
		//upcasting
		Animal obj=new Dog();
		System.out.println(obj.name);
		System.out.println(obj.method());
		//System.out.println(obj.id);
		
		
		//downcasting
		Dog obj1=(Dog) obj;
		System.out.println(obj1.name);
		System.out.println(obj1.method());
		System.out.println(obj1.id);
	}

}
