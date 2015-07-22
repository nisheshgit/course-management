package com.geekmj.seedgs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekmj.seedgs.dao.EmployeeDao;
import com.geekmj.seedgs.dao.UserDao;
import com.geekmj.seedgs.domain.Employee;
import com.geekmj.seedgs.domain.User;
import com.geekmj.seedgs.service.EmployeeService;
import com.geekmj.seedgs.service.UserService;

@Service
public class EmployeeServiceImpl implements EmployeeService{


	@Autowired
	private EmployeeDao employeeDao;	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		employeeDao.insert(employee);
		return employee;
	}

	@Override
	public Employee findEmployeeById(Long employeeId) {
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() {
		return employeeDao.findEmployees();
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		
	}

}
