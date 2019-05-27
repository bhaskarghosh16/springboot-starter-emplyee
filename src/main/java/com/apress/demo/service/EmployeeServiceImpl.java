package com.apress.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.apress.demo.model.Department;
import com.apress.demo.model.Employee;
import com.apress.demo.repository.DepartmentRepository;
import com.apress.demo.repository.EmployeeRepository;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Override
	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Sort sort = new Sort(Direction.DESC,"name");
		return employeeRepository.findAll(sort);
	}

	@Override
	public void insert(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save((employee));
		

	}
	
	
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
		Employee old =getEmployeeById(employee.getId()).orElse(null);
		old.setActive(employee.isActive());
		old.setLastName(employee.getLastName());
		old.setName(employee.getName());
		employeeRepository.save(old);
		;
		
		

	}

	@Override
	public void deleteById(long id) {
		Optional<Employee> employee=getEmployeeById(id);
		if(employee.isPresent())
			employeeRepository.delete(employee.get());
		
	}

	@Override
	public List<Employee> getAllEmployeesWithLastNameAs(String lastName) {
		// TODO Auto-generated method stub
		
		return employeeRepository.findByLastName(lastName,PageRequest.of(1, 2,Sort.by(Sort.Direction.DESC,"name")));
	}

	@Override
	public List<Employee> getAllEmployeesWithGivenCriteria(String criteria, String key) {
		
		// TODO Auto-generated method stub
		
		if(criteria.equalsIgnoreCase("lastName"))
		return employeeRepository.findByLastName(key,PageRequest.of(0, 2,Sort.by(Sort.Direction.DESC,"name")));
		
		
		return employeeRepository.findByName(key);
		
	}

	@Override
	public Department getDepartmentForEmployeeWithId(long id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> e = getEmployeeById(id);
		
		return e.get().getDepartment();
		
		
	}

}