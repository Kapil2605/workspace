package com.kodewala.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.dto.EmployeeRequest;
import com.kodewala.entity.Employee;
import com.kodewala.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createEmployees(@RequestBody EmployeeRequest employeeRequest){
		
		logger.info("Create Employee API");
		logger.debug("Employee Request: name={}, dept={}",employeeRequest.getName(),employeeRequest.getDept());
		
		Employee emp=employeeService.createEmployee(employeeRequest);
		
		if(emp!=null) {
			logger.info("Employee created successfully with id={}",
					emp.getId());
			return ResponseEntity.ok("Employee Created");
		}
		logger.warn("Employee creation failed");
		return ResponseEntity.ok("Not created");
	}
	
	@GetMapping("/get")
	public Page<Employee>getEmployee(@RequestParam("page") int page,@RequestParam("limit") int limit){
		return employeeService.findEmployee(page, limit);
	}
}
