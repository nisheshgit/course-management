package com.geekmj.seedgs.dao;

import java.util.List;

import com.geekmj.seedgs.domain.Employee;

public interface EmployeeDao {

	public Long insert(Employee employee);

	public List<Employee> findEmployees();

	public void deleteEmployeeById(Long userId);	
	
}
