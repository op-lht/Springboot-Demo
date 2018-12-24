package com.lht.bussiness.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lht.bussiness.user.dao.UserDao;
import com.lht.bussiness.user.entity.User;
import com.lht.bussiness.user.service.IUserSevice;

@Service
public class UserServiceImpl implements IUserSevice {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public User find(int userId) {
		return userDao.find(userId);
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public int delete(int userId) {
		return userDao.delete(userId);
	}

}
