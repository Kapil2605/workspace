package com.kodewala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kodewala.dto.EmployeeRequest;
import com.kodewala.entity.Employee;
import com.kodewala.repository.EmployeeRepository;



@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee createEmployee(EmployeeRequest employeeRequest) {
		Employee emp=new Employee();
		emp.setName(employeeRequest.getName());
		emp.setDept(employeeRequest.getDept());
		
		return employeeRepository.save(emp);
	}
	
	public Page<Employee> findEmployee(int page,int limit) {
		Pageable pages=PageRequest.of(page, limit, Sort.by("id").descending());
		return employeeRepository.findAll(pages);
	}
}
