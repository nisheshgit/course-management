package com.geekmj.seedgs.service;

import java.util.List;

import com.geekmj.seedgs.domain.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public Employee findEmployeeById(Long employeeId);

	public List<Employee> findAllEmployee();

	public void deleteEmployeeById(Long employeeId);

}