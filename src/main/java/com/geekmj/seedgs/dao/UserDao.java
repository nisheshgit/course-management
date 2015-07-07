package com.geekmj.seedgs.dao;

import java.util.List;

import com.geekmj.seedgs.domain.User;

public interface UserDao {

	/**
	 * x
	 * 
	 * @param user
	 * @return Long userId of inserted record
	 */
	public Long insert(User user);

	public Integer update(User user);

	public User findUserById(Long id);

	public List<User> findUsers();

	public void deleteUserById(Long userId);

}
