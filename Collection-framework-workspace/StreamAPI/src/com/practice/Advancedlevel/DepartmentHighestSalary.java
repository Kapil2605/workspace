package com.practice.Advancedlevel;

import java.util.*;

class Employees {
    int id;
    String name;
    String department;
    double salary;

    Employees(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class DepartmentHighestSalary {

	public static void main(String[] args) {
		
		List<Employees> employees = Arrays.asList(
			    new Employees(1, "Kapil", "IT", 70000),
			    new Employees(2, "Aman", "HR", 50000),
			    new Employees(3, "Rohit", "IT", 90000),
			    new Employees(4, "Neha", "Finance", 80000),
			    new Employees(5, "Ankit", "HR", 60000)
			);
		
		

	}

}
