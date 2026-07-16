package com.kodewala.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kodewala.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
