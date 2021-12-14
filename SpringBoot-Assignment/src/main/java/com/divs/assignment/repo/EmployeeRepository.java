package com.divs.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divs.assignment.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
	public Employee findById(long emp_id);
	
	public List<Employee> findAll();
}
