package com.employeeQuestion;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

	public static List<Employee> getEmployee() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Kapil", 4000,12,"IT"));
		list.add(new Employee(2, "Rahul", 7000,20,"Finance"));
		list.add(new Employee(3, "Amit", 9000,30,"Banking"));
		list.add(new Employee(4, "Rohit", 6500,57,"IT"));
		list.add(new Employee(5, "Neha", 8000,45,"Finance"));
		list.add(new Employee(6, "Priya", 5000,25,"Marketing"));
		return list;
	}
}
