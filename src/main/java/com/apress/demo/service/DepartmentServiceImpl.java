package com.apress.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.demo.model.Department;
import com.apress.demo.repository.DepartmentRepository;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	@Override
	public Optional<Department> findByDepartmentId(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public void insert(Department department) {
		// TODO Auto-generated method stub
		 departmentRepository.save(department);
	}
	

}
