package com.geekmj.seedgs.dao;

import java.util.List;

import com.geekmj.seedgs.domain.User;

public interface UserDao {

	public Long insert(User user);

	public List<User> findUsers();

	public void deleteUserById(Long userId);	
	
}
