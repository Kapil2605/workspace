package com.kodewala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
