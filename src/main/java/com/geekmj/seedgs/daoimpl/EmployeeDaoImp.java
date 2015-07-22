package com.geekmj.seedgs.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.geekmj.seedgs.dao.EmployeeDao;
import com.geekmj.seedgs.dao.UserDao;
import com.geekmj.seedgs.domain.Employee;
import com.geekmj.seedgs.domain.User;


@Repository
public class EmployeeDaoImp implements EmployeeDao {
	
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public EmployeeDaoImp(DataSource datasource) {
		this.jdbctemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public Long insert(Employee employee) {
		
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbctemplate)
		.withTableName("Employee").usingGeneratedKeyColumns("employeeid");
		final Map<String,Object> employeeMap = new HashMap<>();
		employeeMap.put("name", employee.getName());
		employeeMap.put("age", employee.getAge());
		employeeMap.put("role", employee.getRole());	

		final Number key = jdbcInsert.executeAndReturnKey(employeeMap);
		final Long employeeId = key.longValue();
		
		return employeeId;
	}

	@Override
	public List<Employee> findEmployees() {
		List<Employee> employees = this.jdbctemplate.query(
				"select employeeid,name,age,role from Employee" , new UserMapper());
		return employees;
	}

	
	/* inner class for RowMapper (User) */
	private static final class UserMapper implements RowMapper<Employee> {

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setName(rs.getString("name"));
			employee.setAge(rs.getInt("age"));
			employee.setRole(rs.getString("role"));	
			return employee;
		}
	}
	
	
	@Override
	public void deleteEmployeeById(Long employeeid) {
		this.jdbctemplate.update("delete from Employee where employeeid = ?" , employeeid);
	}

}
