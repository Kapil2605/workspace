package com.spring.usingConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	public Address address() {
		return new Address("Rewari","India");
	}
	
	@Bean
	public Employee employee() {
		return new Employee("K01","Kapil Yadav",address());
	}
	
}
