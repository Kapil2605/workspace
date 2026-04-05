package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beans.Address;
import com.beans.Student;

@Configuration
public class SpringConfig {
	
	@Bean
	public Address createAddress() {
		Address add=new Address();
		add.setPincode(123106);
		add.setCity("Rewari");
		add.setCountry("Bharat");
		return add;
	}
	
	@Bean
	public Student createStudent() {
		Student std=new Student();
		std.setRollNo(11);
		std.setName("kapil");
		//std.setAddress(createAddress()); //manual way of injecting dependency
		return std;
	}
}
