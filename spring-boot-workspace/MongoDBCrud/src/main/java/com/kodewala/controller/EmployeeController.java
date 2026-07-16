package com.kodewala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.entity.Employee;
import com.kodewala.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping
	public List<Employee>findAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee findByID(@PathVariable String id) {
		return employeeService.getByEmployeeId(id);
	}
	
	 // Update
    @PutMapping("/{id}")
    public Employee update(@PathVariable String id,
                           @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
    
 // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }
}
