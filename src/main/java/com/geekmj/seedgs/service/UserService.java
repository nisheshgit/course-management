package com.geekmj.seedgs.service;

import java.util.List;

import com.geekmj.seedgs.domain.User;


public interface UserService {
	
	public User saveUser(User user);

	public List<User> findAllUser();
	
}
