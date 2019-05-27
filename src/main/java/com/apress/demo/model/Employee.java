package com.apress.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="EMPLOYEES")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private boolean active;
	
	private Long salary;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="departmentId",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Department department;
	
	

	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Employee() {
		super();
	}
	/*
	public Employee(String name, String lastName, boolean active) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.active = active;
	}*/


	public Employee(Long id, String name, String lastName, boolean active, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.salary = salary;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}