package com.geekmj.seedgs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekmj.seedgs.dao.UserDao;
import com.geekmj.seedgs.domain.User;
import com.geekmj.seedgs.service.UserService;

@Service
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDao userDao;	
	
	@Override
	public User saveUser(User user) {
		userDao.insert(user);
		return user;
	}

	@Override
	public User findUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUser() {		
		return userDao.findUsers();
	}

	@Override
	public void deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		
	}

}
