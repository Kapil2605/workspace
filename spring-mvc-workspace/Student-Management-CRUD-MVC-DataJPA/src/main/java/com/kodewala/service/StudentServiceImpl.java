package com.kodewala.service;

import java.util.Optional;

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
		return studentRepository.save(student);
	}

	@Transactional
	@Override
	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);
		
	}

	@Override
    public void update(Student student) {
		studentRepository.save(student);
    }

//	@Override
//	public void delete(int id) {
//		int id=studentRepository.deleteById(id);
//	}
	
	

}
