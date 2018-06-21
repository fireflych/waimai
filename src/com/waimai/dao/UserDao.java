package com.waimai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.waimai.entity.User;

public class UserDao {
	
	public User showUser(String userId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from user where userid=?";
		ResultSet rs = null;
		
		User dbUser = new User();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,userId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			dbUser.setUserId(rs.getString(1));
			dbUser.setUserLoginName(rs.getString(2));
			dbUser.setUserNickName(rs.getString(3));
			dbUser.setUserTrueName(rs.getString(4));
			dbUser.setUserPassword(rs.getString(5));
			dbUser.setUserPhone(rs.getString(6));
			dbUser.setUserAddress(rs.getString(7));
			dbUser.setUserCreateTime(rs.getString(8));
		}
		rs.close();
		pstmt.close();
		con.close();
		return dbUser;
	}
	/**
	 * 增加用户
	 * @param user
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void addUser(User user) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,user.getUserId());
		pstmt.setString(2,user.getUserLoginName());
		pstmt.setString(3,user.getUserNickName());
		pstmt.setString(4,user.getUserTrueName());
		pstmt.setString(5,user.getUserPassword());
		pstmt.setString(6,user.getUserPhone());
		pstmt.setString(7,user.getUserAddress());
		pstmt.setString(8,user.getUserCreateTime());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	} 
	
	/**
	 * 登陆时获取用户信息
	 * @param userLoginName
	 * @param userLoginPassword
	 * @return User
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public User getUser(String userPhone,String userPassword) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from user where userphone=? and userpassword=?";
		ResultSet rs = null;
		
		User dbUser = new User();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,userPhone);
		pstmt.setString(2,userPassword);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			dbUser.setUserId(rs.getString(1));
			dbUser.setUserLoginName(rs.getString(2));
			dbUser.setUserNickName(rs.getString(3));
			dbUser.setUserTrueName(rs.getString(4));
			dbUser.setUserPassword(rs.getString(5));
			dbUser.setUserPhone(rs.getString(6));
			dbUser.setUserAddress(rs.getString(7));
			dbUser.setUserCreateTime(rs.getString(8));
		}
		rs.close();
		pstmt.close();
		con.close();
		return dbUser == null?null:dbUser;
	}
	public void userRegister(User user) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,user.getUserId());
		pstmt.setString(2,user.getUserLoginName());
		pstmt.setString(3,user.getUserNickName());
		pstmt.setString(4,user.getUserTrueName());
		pstmt.setString(5,user.getUserPassword());
		pstmt.setString(6,user.getUserPhone());
		pstmt.setString(7,user.getUserAddress());
		pstmt.setString(8,user.getUserCreateTime());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
		
}
