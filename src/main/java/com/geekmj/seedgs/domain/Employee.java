package com.geekmj.seedgs.domain;

import java.io.Serializable;
import java.sql.Time;

public class Employee implements Serializable {
	
	private Long employeeId;
	private String name;
	private Integer age;
	private String role;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	private static final long serialVersionUID = 1L;
		
}
