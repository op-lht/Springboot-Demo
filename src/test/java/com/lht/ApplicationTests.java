package com.lht;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lht.bussiness.user.dao.UserDao;
import com.lht.bussiness.user.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() throws SQLException {
		Connection conn = dataSource.getConnection();
		// 默认的数据库连接池是Hikari
		System.out.println(conn);
	}

	@Test
	public void queryAll() throws SQLException {
		List<User> userList = userDao.queryAll();
		userList.forEach(System.out::println);
	}

}
