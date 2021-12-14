package com.divs.assignment.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
	
	private long emp_id;
	private String emp_name;
	private String email;
	private String phoneNo;
	
	private Set<Department> departments = new HashSet<>();
	
}
