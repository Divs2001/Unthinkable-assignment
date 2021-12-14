package com.divs.assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.divs.assignment.entity.Department;
import com.divs.assignment.entity.DepartmentRequest;
import com.divs.assignment.repo.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Iterable<Department> getAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	public void saveDept(DepartmentRequest department) {

		Department newDept = new Department();
		newDept.setDept_id(department.getDept_id());
		newDept.setName(department.getName());

		departmentRepository.save(newDept);

	}

	public Department updateDept(long dept_id, DepartmentRequest departmentRequest) {
		
		Department dept = departmentRepository.findById(dept_id);
		dept.setName(departmentRequest.getName());
		
		return departmentRepository.save(dept);
		
	}

}
