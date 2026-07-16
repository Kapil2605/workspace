package com.employeeQuestion;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SecondHighestSalaryEachDepartment {
	public static void main(String[] args) {
		List<Employee> list = EmployeeData.getEmployee();
		
		Map<Object, Object>result=list.stream().collect(
						Collectors.groupingBy(s->s.getDept(),
						Collectors.collectingAndThen(
								Collectors.toList(),
								e->e.stream().sorted((a,b)->b.getSalary()-a.getSalary())
								.skip(1)
								.findFirst())));
		
		
	}
}
