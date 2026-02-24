package com.kodewala.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean("user")
	public User createUser() {
		User user=new User();
		user.setFirstName("Kodewala");
		user.setLastName("Academy");
		user.setEmail("Kodewala@gmail.com");;
		
		return user;
	}
}
