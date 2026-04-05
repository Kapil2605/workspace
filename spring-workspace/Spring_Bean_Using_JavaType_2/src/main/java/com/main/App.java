package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Employee;
import com.config.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
//       Employee e1=(Employee) context.getBean("emp1");
//       e1.display();
       
       //2nd way
       Employee e2=(Employee) context.getBean("myEmp1");
       e2.display();
       
       Employee e3=(Employee) context.getBean("myEmp2");
       e3.display();
    }
}
