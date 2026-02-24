package com.constructor;

class Company{
	String name;
	
	Company(String name){
		this.name=name;
	}
}

class Employee extends Company{
	String empNamee;
	String empID;
	
	Employee(String empNamee,String empID,String name){
		super(name);
		this.empNamee=empNamee;
		this.empID=empID;
		
		System.out.println("Employee name:"+empNamee);
		System.out.println("Employee ID:"+empID);
		System.out.println("Employee Company:"+name);
	}
}
public class Driver {
	
	public static void main(String[] args) {
		Employee obj=new Employee("K01","Kapil","Microsoft");
	}
	
	
}
