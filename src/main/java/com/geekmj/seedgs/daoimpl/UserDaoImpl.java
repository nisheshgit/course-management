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
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Long insert(User user) {

		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("user").usingGeneratedKeyColumns("user_id");

		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", user.getName());
		parameters.put("age", user.getAge());
		final Number key = jdbcInsert.executeAndReturnKey(parameters);
		final Long userId = key.longValue();

		/* Without Returning Auto Generated Primary Key */
		// return this.jdbcTemplate.update(
		// "insert into user (name, age) values (?, ?)",
		// user.getName(), user.getAge());

		return userId;
	}

	@Override
	public User findUserById(Long id) {
		User user = this.jdbcTemplate.queryForObject(
				"select user_id, name, age from user where user_id = ?",
				new Object[] { id }, new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setUserId(rs.getLong("user_id"));
						user.setName(rs.getString("name"));
						user.setAge(rs.getInt("age"));
						return user;
					}
				});
		return user;
	}

	@Override
	public List<User> findUsers() {
		List<User> users = this.jdbcTemplate.query(
				"select user_id, name, age from user", new UserMapper());
		return users;
	}

	/* inner class for RowMapper (User) */
	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getLong("user_id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			return user;
		}
	}

	@Override
	public Integer update(User user) {

		return this.jdbcTemplate.update(
				"update user set name = ?, age =? where user_id = ?",
				user.getName(), user.getAge(), user.getUserId());
	}

	@Override
	public void deleteUserById(Long userId) {
		this.jdbcTemplate.update("delete from user where user_id = ?", userId);

	}

}
