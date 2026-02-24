package com.springcore;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springcore.Student;

public class App{

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Config.xml");

        Student student = context.getBean("student", Student.class);
        student.display();
    }
}
