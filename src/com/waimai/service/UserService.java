package com.waimai.service;

import java.sql.SQLException;

import com.waimai.dao.UserDao;
import com.waimai.entity.User;

public class UserService {
	
	public User showUser(String userId) throws Exception{
		UserDao userDao = new UserDao();
		return userDao.showUser(userId);
	}

	public void addUser(User user) throws Exception{
		UserDao userDao = new UserDao();
		userDao.addUser(user);
	}

	public User userLogin(String userPhone,String userPassword) throws Exception{
		UserDao userDao = new UserDao();
		User user = userDao.getUser(userPhone, userPassword);
		if(user != null) user.setUserPassword(null);
		return user;
	}
	
	public void userRegister(User user) throws Exception{
		UserDao userDao = new UserDao();
		userDao.userRegister(user);
	}
}
