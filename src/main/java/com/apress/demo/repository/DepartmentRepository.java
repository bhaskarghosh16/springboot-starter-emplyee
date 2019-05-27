package com.apress.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apress.demo.model.Department;
import com.apress.demo.model.Employee;

@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department, Long>{
		@Query(value = "SELECT * FROM EMPLOYEES WHERE DepartmentId =?1",nativeQuery=true)
		List<Employee> getEmployeesByDepartmentId(Long id);
}
