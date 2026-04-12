package com.kodewala.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entities.Student;
import com.kodewala.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public boolean addStudentDetails(Student s) {
	    try {
	        studentRepository.save(s);
	        return true;
	    } catch(Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentDetails(long id) {
		Optional<Student>std=studentRepository.findById(id);
		if(std.isPresent()) {
			return std.get();
		}
		return null;
	}

	@Override
	public boolean updateStudent(long id, float marks) {
		Student std=getStudentDetails(id);
		if(std!=null) {
			std.setMarks(marks);
			studentRepository.save(std);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudent(long id) {
		try {
			studentRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
