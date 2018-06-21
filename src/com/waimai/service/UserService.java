package com.waimai.service;

import java.sql.SQLException;

import com.waimai.dao.UserDao;
import com.waimai.entity.User;

public class UserService {

	private UserDao userDao;
	
	public User showUser(String userId) throws ClassNotFoundException, SQLException{
		return userDao.showUser(userId);
	}

	public void addUser(User user) throws ClassNotFoundException, SQLException{
		userDao.addUser(user);
	}

	public User userLogin(String userPhone,String userPassword) throws ClassNotFoundException, SQLException{
		User user = userDao.getUser(userPhone, userPassword);
		if(user != null) user.setUserPassword(null);
		return user;
	}
	
	public void userRegister(User user) throws ClassNotFoundException, SQLException{
		userDao.userRegister(user);
	}
/* 
 	===============================Getter Setter Constructor=====================================
*/
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
