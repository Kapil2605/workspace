package com.spring.usingConstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	static int x=10;
	
	public static void main(String[] args) {
		System.out.println(x);
		System.out.println(x+30);
		System.out.println(x);
		/*
		 * ApplicationContext context=new
		 * AnnotationConfigApplicationContext(SpringConfig.class); Employee
		 * emp=context.getBean(Employee.class); emp.display();
		 */
	}
}
