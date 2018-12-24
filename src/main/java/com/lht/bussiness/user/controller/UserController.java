package com.lht.bussiness.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lht.bussiness.user.entity.User;
import com.lht.bussiness.user.service.IUserSevice;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserSevice userSevice;

	@GetMapping("/list")
	public ResponseEntity<List<User>> findAllUser() {
		List<User> userList = userSevice.queryAll();
		if (userList.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(userList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Integer id) {
		User user = userSevice.find(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(user);
	}

	@GetMapping("/add")
	public ResponseEntity<String> addUser(User user) {// springmvc会根据参数名字自动封装生对象
														// http://localhost:8875/lht/user/add?userName=yyy&&mobile=123456&&password=1234546789
		int isAdded = userSevice.insert(user);
		return ResponseEntity.ok(isAdded > 0 ? "添加成功" : "添加失败");
	}

	@GetMapping("/del/{id}")
	public ResponseEntity<String> delUser(@PathVariable Integer id) {
		int isDeleted = userSevice.delete(id);
		return ResponseEntity.ok(isDeleted > 0 ? "删除成功" : "删除失败");
	}
}
