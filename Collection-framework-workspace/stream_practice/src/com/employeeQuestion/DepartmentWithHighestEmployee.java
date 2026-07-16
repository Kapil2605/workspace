package com.employeeQuestion;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DepartmentWithHighestEmployee {
	public static void main(String[] args) {
		List<Employee>list=EmployeeData.getEmployee();
		Map<String,Long>result=list.stream().collect(Collectors.groupingBy(e->e.getDept(),Collectors.counting()));
		
//		for (Entry<String, Long> entry : result.entrySet()) {
//		    System.out.println(entry.getKey() + " " + entry.getValue());
//		}
		
		Entry<String, Long>highestDept=result.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		
		System.out.println("Department: " + highestDept.getKey());
		System.out.println("Employee Count: " + highestDept.getValue());
	}
}
