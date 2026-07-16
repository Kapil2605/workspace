package com.employeeQuestion;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentWithSalaryGreaterThan70000 {
	public static void main(String[] args) {
		List<Employee> list = EmployeeData.getEmployee();
		
		list.stream().collect(Collectors.groupingBy(e->e.getDept(),
				Collectors.collectingAndThen(Collectors.toList(),
						employees -> employees.stream().filter(emp -> emp.getSalary() > 70000)
                        .collect(Collectors.toList()))));
	}
}
