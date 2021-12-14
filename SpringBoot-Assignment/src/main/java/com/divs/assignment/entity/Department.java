package com.divs.assignment.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Department extends AuditableBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dept_id;
	private String name;
	
	@ManyToMany( mappedBy = "departments")
	@JsonIgnore
	private Set<Employee> employees = new HashSet<>();

	public Department(String name) {
		super();
		this.name = name;
	}

	public Department() {
		super();
	}
	
	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	
}
