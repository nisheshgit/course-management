package com.geekmj.seedgs.dao;

import java.util.List;

import com.geekmj.seedgs.domain.User_course;

public interface UserDao_course {

	/**
	 * x
	 * 
	 * @param user
	 * @return Long userId of inserted record
	 */
	public Long insert(User_course user);

	public Integer update(User_course user);

	public User_course findUserById(Long id);

	public List<User_course> findUsers();

	public void deleteUserById(Long userId);

}
