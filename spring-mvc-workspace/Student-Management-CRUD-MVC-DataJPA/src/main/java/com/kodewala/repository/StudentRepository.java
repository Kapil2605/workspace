package com.kodewala.repository;

import org.springframework.data.repository.CrudRepository;

import com.kodewala.entity.Student;

public  interface StudentRepository extends CrudRepository<Student, Integer>{
	
	
}