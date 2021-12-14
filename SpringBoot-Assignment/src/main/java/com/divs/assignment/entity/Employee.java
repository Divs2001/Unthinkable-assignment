package com.divs.assignment.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee extends AuditableBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long emp_id;
	private String emp_name;
	private String email;
	private String phoneNo;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "Emp_Dept", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "dept_id") })
	@JsonIgnore
	private Set<Department> departments = new HashSet<>();

	public Employee(long emp_id, String emp_name, String email, String phoneNo) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
