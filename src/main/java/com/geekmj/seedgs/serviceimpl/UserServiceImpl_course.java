package com.geekmj.seedgs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekmj.seedgs.dao.UserDao_course;
import com.geekmj.seedgs.domain.User_course;
import com.geekmj.seedgs.service.UserService_course;

@Service
public class UserServiceImpl_course implements UserService_course {

	@Autowired
	private UserDao_course userDao;

	@Override
	public User_course saveUser(User_course user) {
		Long userId = null;
		if (user.getUserId() == null) {
			userId = userDao.insert(user);
		} else {
			userId = user.getUserId();
			userDao.update(user);
		}

		user = userDao.findUserById(userId);

		return user;
	}

	@Override
	public List<User_course> findAllUser() {

		return userDao.findUsers();
	}

	@Override
	public User_course findUserById(Long userId) {

		return userDao.findUserById(userId);
	}

	@Override
	public void deleteUserById(Long userId) {
		userDao.deleteUserById(userId);

	}

}
