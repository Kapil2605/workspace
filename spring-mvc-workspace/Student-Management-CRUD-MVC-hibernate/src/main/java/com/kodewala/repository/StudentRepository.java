package com.kodewala.repository;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kodewala.entity.Student;

@Repository
public class StudentRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//@Transactional
	public Student addStudent(Student std) {
		 sessionFactory.getCurrentSession().save(std);
		 return std;
		
	}
	
	@Transactional
	public Student getById(int id) {
		return sessionFactory.getCurrentSession().get(Student.class, id);
	}
	
	@Transactional
    public void update(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }
	
	@Transactional
    public boolean delete(int id) {
		Student std = sessionFactory.getCurrentSession().get(Student.class, id);
        if (std != null) {
            sessionFactory.getCurrentSession().delete(std);
            return true;
        }
		return false;
    }
}
