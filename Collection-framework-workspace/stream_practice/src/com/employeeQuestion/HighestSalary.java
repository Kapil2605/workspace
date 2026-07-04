package com.employeeQuestion;

import java.util.List;

public class HighestSalary {

	public static void main(String[] args) {
		List<Employee>list=EmployeeData.getEmployee();
		Employee emp=list.stream().sorted((a,b)->b.getSalary()-a.getSalary()).findFirst().get();
		System.out.println(emp.id+ " "+emp.name+" "+emp.salary);
	}
}
