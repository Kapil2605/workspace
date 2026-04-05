package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	String path="/com/kodewala/SpringConfig.xml";
       ApplicationContext context =new ClassPathXmlApplicationContext(path);
       
       Employee emp1=(Employee) context.getBean("myEmpObj1");
       
       emp1.display();
       
       System.out.println("-------------------");
       Employee emp2=(Employee) context.getBean("myEmpObj2");
       
       emp2.display();
    }
}
