package com.kodewala;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kodewala.entities.Student;
import com.kodewala.services.StudentService;
import com.kodewala.services.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringBootDataJpa1Application.class, args);
		StudentService service=context.getBean(StudentServiceImpl.class);
		
		/* ---this will be used to insert data into database
		Student s=new Student();
		s.setName("Aman Yadav");
		s.setRollno(8);
		s.setMarks(90.5f);
		
		boolean status=service.addStudentDetails(s);
		if(status) {
			System.out.println("Student inserted");
		}
		else {
			System.out.println("Not inserted");
		}
		*/
		
		
		//get all student from database
		/*
		List<Student>list=service.getAllStudent();
		for(Student std:list) {
			System.out.println(std.getId());
			System.out.println(std.getName());
			System.out.println(std.getRollno());
			System.out.println(std.getMarks());
			System.out.println("----------------------");
		}
		*/
		
		/*
		//get student by id
		Student std=service.getStudentDetails(4l);
		System.out.println(std.getId());
		System.out.println(std.getName());
		System.out.println(std.getRollno());
		System.out.println(std.getMarks());
		*/
		
		/*
		//update student 
		boolean status=service.updateStudent(4l, 89.5f);
		if(status) {
			System.out.println("Student updated successfully");
		}
		else {
			System.out.println("Not updated");
		}
		*/
		
		
		//delete student 
		boolean status=service.deleteStudent(4l);
		if(status) {
			System.out.println("Student deleted successfully");
		}
		else {
			System.out.println("Not deleted");
		}
	}
	

}
