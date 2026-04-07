package com.kodewala;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.entity.User;

@SpringBootApplication
public class SpringBootHibernate1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernate1Application.class, args);
		Configuration cfg=new Configuration();
        cfg.configure("in/config/hibernate.cfg.xml");
        
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        
      //select data from database
        try {
        	User user=session.get(User.class,1L);
        	if(user!=null) {
        		System.out.println(user.getName());
        		System.out.println(user.getEmail());
        		System.out.println(user.getPassword());
        		System.out.println(user.getGender());
        		System.out.println(user.getCity());
        	}
        }catch(Exception e) {
        	e.printStackTrace();;
        }
	}

}
