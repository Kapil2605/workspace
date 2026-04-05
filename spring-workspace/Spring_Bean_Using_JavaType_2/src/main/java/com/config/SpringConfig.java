package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bean.Employee;

@Configuration
public class SpringConfig {
	
	@Bean("myEmp1")
	public Employee createEmp1() {
		Employee emp=new Employee();
		emp.setId(1);
		emp.setName("Kapil Yadav");
		return emp;
	}
	
	@Bean("myEmp2")
	public Employee createEmp2() {
		Employee emp=new Employee();
		emp.setId(2);
		emp.setName("Aman Yadav");
		return emp;
	}
}
