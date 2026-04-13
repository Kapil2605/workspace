package com.kodewala.service;

import java.util.List;

import com.kodewala.entities.Student;

public interface StudentService {
	public boolean addStudentDetails(Student s);
	public List<Student> getAllStudent();
	public Student getStudentDetails(long id);
	public boolean updateStudent(long id,float marks);
	public boolean deleteStudent(long id);
}