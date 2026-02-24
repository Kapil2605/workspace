package com.kodewala.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee emp=(Employee) context.getBean("myEmpObj");
		System.out.println(emp.getFirstName());
	}
}
