package com.apress.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DEPARTMENTS")
public class Department {
	
	
	public Department(Long departmentId, String name, boolean active) {
		super();
		
		this.name = name;
		this.active = active;
	}

	public Department(Long departmentId, String name, boolean active, Set<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.active = active;
		this.employees = employees;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long departmentId;
	
	private String name;
	
	private boolean active;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Employee> employees;
	
	public Long getId() {
		return departmentId;
	}

	public void setId(Long id) {
		this.departmentId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	

	public Department( String name, boolean active) {
		super();
		
		this.name = name;
		this.active = active;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	
	

	

}
