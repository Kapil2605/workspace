package com.employeeQuestion;

import java.util.List;
import java.util.stream.Collectors;

public class Top5HighestSalary {
	public static void main(String[] args) {
		List<Employee>list=EmployeeData.getEmployee();
		List<Employee>result=list.stream().sorted((a,b)->b.getSalary()-a.getSalary()).limit(5).collect(Collectors.toList());
		
		for(Employee emp:result) {
			System.out.println(emp.getSalary());
		}
		
		}
}
