package com.apress.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apress.demo.model.Department;
import com.apress.demo.model.Employee;
import com.apress.demo.service.EmployeeService;


@RestController
@RequestMapping(value = {"/"})
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String greet() {
			return "Hello BoksaSodas";
		}
	
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Optional<Employee> getEmployee(@PathVariable("id") long id) {
    	
		return employeeService.getEmployeeById(id);
	}
    
    @RequestMapping(value = "/employee/new", method = RequestMethod.POST)
    public ResponseEntity <String> persistEmployee(@RequestBody Employee employee) {
	    	
    	employeeService.insert(employee);
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @RequestMapping(value = "/employee/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity <String> updateEmployee(@RequestBody Employee employee,@PathVariable("id") long id) {
	    employee.setId(id);
    	employeeService.update(employee);
    	return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity <String> deleteEmployee(@PathVariable("id") long id) {
	   
    	employeeService.deleteById(id);
    	return ResponseEntity.status(HttpStatus.OK).build();
    } 
    @RequestMapping(value = "/employee/getlastname", method = RequestMethod.GET)
    public List<Employee> getEmployeesWithLastName(@RequestParam(required = false)String lastName) {
		return employeeService.getAllEmployeesWithLastNameAs(lastName);
	}
    
    @RequestMapping(value = "/employee/search", method = RequestMethod.GET)
    public List<Employee> getEmployeesWithCriteria(@RequestParam String criteria,@RequestParam String key) {
    	System.out.println(criteria+" "+key);
		return employeeService.getAllEmployeesWithGivenCriteria(criteria, key);
	}
    
    @RequestMapping(value = "/employee/{id}/department", method = RequestMethod.GET)
    public Department getDepartmentForEmployee(@PathVariable("id") long id) {
    	return employeeService.getDepartmentForEmployeeWithId(id);
	}
    
    
}