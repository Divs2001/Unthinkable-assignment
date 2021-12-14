package com.divs.assignment.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divs.assignment.entity.Department;
import com.divs.assignment.entity.Employee;
import com.divs.assignment.entity.EmployeeRequest;
import com.divs.assignment.repo.DepartmentRepository;
import com.divs.assignment.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;


	public List<Employee> getAll() {
		
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(EmployeeRequest employee) {
		
		Employee newEmployee = new Employee();
		newEmployee.setEmp_id(employee.getEmp_id());
		newEmployee.setEmp_name(employee.getEmp_name());
		newEmployee.setPhoneNo(employee.getPhoneNo());
		newEmployee.setEmail(employee.getEmail());
		newEmployee.setDepartments(employee.getDepartments()
				.stream().map(department->{
					Department dept = department;
					if(dept.getDept_id()> 0) {
						dept = departmentRepository.findById(dept.getDept_id());
					}
//					else {
//						dept = new Department();		
//					}
//					dept.setDept_name(null)
					dept.addEmployee(newEmployee);
					return dept;
				}).collect(Collectors.toSet()));
		
		
		return employeeRepository.save(newEmployee);
		
	}

	public Employee updateEmployee(long emp_id, EmployeeRequest employee) {
		
		Employee emp = employeeRepository.findById(emp_id);
		if(employee.getEmp_name()!=null) {
			emp.setEmp_name(employee.getEmp_name());
		}
		
		if(employee.getEmp_name()!=null) {
			emp.setEmail(employee.getEmail());
		}
		
		if(employee.getEmp_name()!=null) {
			emp.setPhoneNo(employee.getPhoneNo());
		}
		
		
		Set<Department> hs = emp.getDepartments();	
		for(Department x : employee.getDepartments()) {
			hs.add(x);
		}
		emp.setDepartments(hs);
		return employeeRepository.save(emp);
	}

}
