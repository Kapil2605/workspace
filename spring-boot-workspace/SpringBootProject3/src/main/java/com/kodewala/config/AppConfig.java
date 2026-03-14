package com.kodewala.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kodewala.SpringBootProject3Application;
import com.kodewala.bean.Student;

@Configuration
public class AppConfig {
	
	@Bean
	public CommandLineRunner cmdLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				stdBean1().display();
				System.out.println("......................");
				stdBean2().display();
			}
		};
	}

    @Bean
    public Student stdBean1() {
        return new Student(1, "Kapil", 101);
    }
    
    @Bean
    public Student stdBean2() {
        return new Student(2, "Rahul", 102);
    }

}