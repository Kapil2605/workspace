package com.kodewala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.Employee;
import com.kodewala.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//create
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//get
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	//read by id
	public Employee getByEmployeeId(String id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	//update by id
	public Employee updateEmployee(String id,Employee employee) {
		Employee existingEmployee=employeeRepository.findById(id).orElse(null);
		
		if(existingEmployee!=null) {
			existingEmployee.setName(employee.getName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setSalary(employee.getSalary());
		}
		return employeeRepository.save(existingEmployee);
	}
	
	 // Delete
    public String deleteEmployee(String id) {

        employeeRepository.deleteById(id);

        return "Employee deleted successfully";
    }
}
