package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beans.Student;
import com.config.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        Student std=(Student) context.getBean("createStudent");
        System.out.println(std.getName());
        System.out.println(std.getAddress());
    }
}
