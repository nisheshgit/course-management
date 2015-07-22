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

import com.geekmj.seedgs.dao.UserDao;
import com.geekmj.seedgs.domain.User;


@Repository
public class UserDaoImp implements UserDao {
	
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public UserDaoImp(DataSource datasource) {
		this.jdbctemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public Long insert(User user) {
		
		System.out.println(user.getName() + user.getEmail() + user.getPassword());
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbctemplate)
		.withTableName("User").usingGeneratedKeyColumns("userid");
		final Map<String,Object> userMap = new HashMap<>();
		userMap.put("name", user.getName());
		userMap.put("pass", user.getPassword());
		userMap.put("email", user.getEmail());	

		final Number key = jdbcInsert.executeAndReturnKey(userMap);
		final Long userId = key.longValue();
		
		return userId;
	}

	@Override
	public List<User> findUsers() {
		List<User> users = this.jdbctemplate.query(
				"select userid,name,email,pass from User" , new UserMapper());
		return users;
	}

	
	/* inner class for RowMapper (User) */
	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("pass"));
			user.setEmail(rs.getString("email"));	
			return user;
		}
	}
	
	
	@Override
	public void deleteUserById(Long userId) {
		this.jdbctemplate.update("delete from User where userid = ?" , userId);
	}

}
