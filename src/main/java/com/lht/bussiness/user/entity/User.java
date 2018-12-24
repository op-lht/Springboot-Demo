package com.lht.bussiness.user.entity;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) // 开启链式编程模式
public class User {
	private Long userId;
	private String userName;
	private String mobile;
	private String password;
	private Date createTime;

	public static void main(String[] args) {
		User user = new User().setCreateTime(new Date()).setMobile("17735342973").setPassword("123456")
				.setUserName("David");
		System.out.println(user);
	}
}
