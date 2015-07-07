package com.geekmj.seedgs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekmj.seedgs.dao.UserDao;
import com.geekmj.seedgs.domain.User;
import com.geekmj.seedgs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User saveUser(User user) {
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
	public List<User> findAllUser() {

		return userDao.findUsers();
	}

	@Override
	public User findUserById(Long userId) {

		return userDao.findUserById(userId);
	}

	@Override
	public void deleteUserById(Long userId) {
		userDao.deleteUserById(userId);

	}

}
