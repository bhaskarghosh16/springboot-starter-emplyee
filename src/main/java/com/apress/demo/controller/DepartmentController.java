package com.apress.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apress.demo.model.Department;

import com.apress.demo.service.DepartmentService;

@RestController
@RequestMapping(value = {"/department"})
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	 @RequestMapping(value = "/new", method = RequestMethod.POST)
	    public ResponseEntity <String> persistEmployee(@RequestBody Department department) {
		    	
		 	departmentService.insert(department);
	    	return ResponseEntity.status(HttpStatus.OK).build();
	    }
	

}
