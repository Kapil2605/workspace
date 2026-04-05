package com.kodewala.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //create and manage the object(bean)
public class Employee {
	@Value("kodewala")
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}
}
