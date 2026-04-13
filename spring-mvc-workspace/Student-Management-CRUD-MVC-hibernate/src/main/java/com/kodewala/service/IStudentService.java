package com.kodewala.service;

import org.springframework.stereotype.Service;

import com.kodewala.entity.Student;

public interface IStudentService {
	public Student create(Student student);

	public Student getStudentById(int id);
	
	void update(Student student);
	
	boolean delete(int id);
}
