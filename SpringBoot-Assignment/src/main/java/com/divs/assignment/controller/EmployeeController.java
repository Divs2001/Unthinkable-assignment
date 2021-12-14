package com.divs.assignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divs.assignment.entity.Department;
import com.divs.assignment.entity.Employee;
import com.divs.assignment.entity.EmployeeRequest;
import com.divs.assignment.repo.DepartmentRepository;
import com.divs.assignment.services.EmployeeService;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	@GetMapping(path="/getAll")
	public List<Employee> getEmployees(){
		return employeeService.getAll();
	}
	
	@PostMapping(path="saveEmployee")
	public Employee saveEmployee(@RequestBody EmployeeRequest employee) {
		
		
		return employeeService.saveEmployee(employee);
		
	}
	
	@PutMapping(path="/updateEmployee")
	public Employee updateEmployee(@RequestParam long emp_id, @RequestBody EmployeeRequest employee) {
		
		return employeeService.updateEmployee(emp_id, employee);
	}
}
