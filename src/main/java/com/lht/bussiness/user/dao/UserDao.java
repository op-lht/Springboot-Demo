package com.lht.bussiness.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lht.bussiness.user.entity.User;

@Mapper
public interface UserDao {
	List<User> queryAll();

	User find(int userId);

	int insert(User user);

	int delete(int userId);
}
