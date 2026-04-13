package com.kodewala.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.Student;
import com.kodewala.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	@Override
	public Student create(Student student) {
		return studentRepository.addStudent(student);
	}

	@Transactional
	@Override
	public Student getStudentById(int id) {
		return studentRepository.getById(id);
		
	}

	@Override
    public void update(Student student) {
		studentRepository.update(student);
    }

	@Override
	public boolean delete(int id) {
		return studentRepository.delete(id);
	}
	
	

}
