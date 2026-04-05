package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bean.Account;
import com.config.AppConfig;

public class App {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		Account acc=(Account)context.getBean(Account.class);
		acc.display();
		
		((AbstractApplicationContext) context).close();
	}

}
