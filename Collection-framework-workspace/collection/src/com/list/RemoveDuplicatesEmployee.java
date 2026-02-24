package com.list;

import java.util.ArrayList;

class Employee{
	int id;
	String name;
	
	Employee(int id,String name){
		this.id=id;
		this.name=name;
	}
}
public class RemoveDuplicatesEmployee {

	public static void main(String[] args) {
		ArrayList<Employee>list=new ArrayList<>();
		list.add(new Employee(12,"Kapil"));
		list.add(new Employee(13,"Yadav"));
		list.add(new Employee(14,"Khola"));
		list.add(new Employee(12,"Kapil"));
		list.add(new Employee(14,"Khola"));
		
		ArrayList<Employee>unique=new ArrayList<Employee>();
		
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).id==list.get(j).id) {
					list.remove(j);
					j--; 
				}
			}
		}
		for(Employee e:list) {
			System.out.println(e.id+" "+e.name);
		}
	}
	

}
