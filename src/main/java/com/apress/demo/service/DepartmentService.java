package com.apress.demo.service;

import java.util.List;
import java.util.Optional;

import com.apress.demo.model.Department;

public interface DepartmentService {
	
	Optional<Department> findByDepartmentId(Long id);
	List<Department> getAllDepartments();
	void insert(Department department);
	
}
