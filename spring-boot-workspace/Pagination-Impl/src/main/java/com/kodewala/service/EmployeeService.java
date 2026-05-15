package com.kodewala.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kodewala.controller.EmployeeController;
import com.kodewala.dto.EmployeeRequest;
import com.kodewala.entity.Employee;
import com.kodewala.repository.EmployeeRepository;



@Service
public class EmployeeService {

	private static final Logger logger=LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee createEmployee(EmployeeRequest employeeRequest) {
		logger.info("Creating employee in service layer");
		Employee emp=new Employee();
		emp.setName(employeeRequest.getName());
		emp.setDept(employeeRequest.getDept());
		
		Employee savedEmployee = employeeRepository.save(emp);

		logger.info("Employee saved in DB with id={}",
				savedEmployee.getId());

		return savedEmployee;
	}
	
	public Page<Employee> findEmployee(int page,int limit) {
		Pageable pages=PageRequest.of(page, limit, Sort.by("id").descending());
		return employeeRepository.findAll(pages);
	}
}
