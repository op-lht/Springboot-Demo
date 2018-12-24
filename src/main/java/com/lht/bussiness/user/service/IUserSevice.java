package com.lht.bussiness.user.service;

import java.util.List;

import com.lht.bussiness.user.entity.User;

public interface IUserSevice {
	List<User> queryAll();

	User find(int userId);

	int insert(User user);

	int delete(int userId);
}
