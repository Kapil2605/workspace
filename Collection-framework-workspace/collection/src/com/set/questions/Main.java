package com.set.questions;
class Students{
	String name;
	
	Students(String name){
		this.name=name;
	}
}
public class Main{
	public static void main(String[] args) {
		/*
		 * String obj1=new String("Kapil"); String obj2=new String("Kapil");
		 * 
		 * System.out.println(obj1.equals(obj2)); //int hasCode1=obj1; int
		 * hasCode2=obj2.hashCode(); //System.out.println(hasCode1.equals(hasCode2));
		 * //System.out.println(hasCode1==hasCode2);
		 */		
		Students s1=new Students("Kapil");
		Students s2=new Students("Kapil");
		
	}
}
