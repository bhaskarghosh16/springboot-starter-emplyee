package com.apress.demo.repository;



import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apress.demo.model.Department;
import com.apress.demo.model.Employee;
import java.lang.String;
import java.util.List;



@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	List<Employee> findByLastName(String lastname, Pageable pageable);
	List<Employee> findByName(String name);
	
	
	
//	@Query(value="SELECT * FROM EMPLOYEES WHERE :criteria = :key",nativeQuery=true)
//	List<Employee> findByCriteria(@Param("criteria") String criteria,@Param("key") String key);

}
