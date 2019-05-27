package com.apress.demo.service;



import java.util.List;
import java.util.Optional;

import com.apress.demo.model.Department;
import com.apress.demo.model.Employee;



public interface EmployeeService {
	Optional<Employee> getEmployeeById(long id);
	List<Employee> getAllEmployeesWithLastNameAs(String lastName);
	List<Employee> getAllEmployees();
	List<Employee> getAllEmployeesWithGivenCriteria(String criteria, String key);
	void insert(Employee employee);
	void update(Employee employee);
	void deleteById(long id);
	Department getDepartmentForEmployeeWithId(long id);
	
}
