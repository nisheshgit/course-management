package com.geekmj.seedgs.service;

import java.util.List;

import com.geekmj.seedgs.domain.User_course;

public interface UserService_course {

	public User_course saveUser(User_course user);

	public User_course findUserById(Long userId);

	public List<User_course> findAllUser();

	public void deleteUserById(Long userId);

}
