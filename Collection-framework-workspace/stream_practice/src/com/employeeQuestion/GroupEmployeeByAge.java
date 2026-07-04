package com.employeeQuestion;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class GroupEmployeeByAge {

	public static void main(String[] args) {
		List<Employee> list = EmployeeData.getEmployee();
		Map<Integer, List<Employee>>result=list.stream().collect(Collectors.groupingBy(s->s.getAge()));
		

		result.forEach((age, employees) -> {

		    System.out.println("Age : " + age);

		    employees.forEach(emp ->
		        System.out.println(emp.getId() + " "
		                + emp.getName() + " "
		                + emp.getSalary() + " "
		                + emp.getAge()));
		});
		}
	

}
