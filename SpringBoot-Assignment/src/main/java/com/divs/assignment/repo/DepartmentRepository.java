package com.divs.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divs.assignment.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department findById(long dept_id);

	public Department findByName(String name);
}
