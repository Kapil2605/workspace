package com.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bean.Address;
import com.bean.Student;

@Configuration
public class SpringConfig {
	
	@Bean
	public Address createAddress1() {
		Address add=new Address();
		add.setCity("Rewari");
		add.setCountry("Bharat");
		add.setPincode(123106);
		return add;
	}
	@Bean
	@Primary //this will give default first priorty to this bean or you can use @qualifier("createAddess2") for specific priorty
	public Address createAddress2() {
		Address add=new Address();
		add.setCity("Bengalore");
		add.setCountry("Bharat");
		add.setPincode(123321);
		return add;
	}
	@Bean
	public Student createStudent() {
		Student std=new Student();
		std.setId(07);
		std.setName("Kapil Yadav");
		//std.setAddress(createAddress()); //manual way of injecting dependency use autowired
		return std;
	}
}
