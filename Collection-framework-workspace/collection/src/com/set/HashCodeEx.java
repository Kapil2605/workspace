package com.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
class Customers{
	String name;
	
	Customers(String name){
		this.name=name;
	}
}
public class HashCodeEx {
	public static void main(String... args) {
		Customers c1=new Customers("Kapil");
		Customers c2=new Customers("Kapil");
		
		System.out.println(c1.equals(c2));
		System.out.println(c1==c2);
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}
