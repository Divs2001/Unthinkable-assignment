package com.divs.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divs.assignment.entity.Department;
import com.divs.assignment.entity.DepartmentRequest;
import com.divs.assignment.services.DepartmentService;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(path = "/getAll")
	public Iterable<Department> getAll() {

		return departmentService.getAll();
	}

	@PostMapping(path = "/saveDept")
	public String saveDept(@RequestBody DepartmentRequest department) {

		departmentService.saveDept(department);
		return "Saved";
	}
	
	@PutMapping(path="/updateDept")
	public Department updateDept(@RequestParam long dept_id, @RequestBody DepartmentRequest departmentRequest) {
		
		return departmentService.updateDept(dept_id, departmentRequest);
		
		
	}

}

