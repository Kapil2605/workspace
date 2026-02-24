package com.spring.setterMethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	public Address address() {
		return new Address("Rewari","Haryana");
	}
	@Bean
	public Employee employee() {
		Employee emp=new Employee();
		emp.setAddress(address());
		emp.setId("K011");
		emp.setName("Kapil Khola");
		return emp;
	}
}
