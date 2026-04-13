package com.kodewala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.entities.Student;

import in.entity.User;

public interface StudentRepository extends JpaRepository<Student, Long>{
  
}
