package com.waimai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.waimai.entity.Area;
import com.waimai.entity.Member;
import com.waimai.entity.User;

public class ShopDao {

	public Member shopLogin(String shopPhone,String shopPassword) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where memberphone=? and memberpassword=?";
		ResultSet rs = null;
		
		Member dbMember = new Member();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,shopPhone);
		pstmt.setString(2,shopPassword);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			dbMember.setMemberId(rs.getString(1));
			dbMember.setMemberName(rs.getString(2));
			dbMember.setMemberPhone(rs.getString(3));
			dbMember.setMemberPassword(rs.getString(4));
			dbMember.setShopName(rs.getString(5));
			dbMember.setShopAdress(rs.getString(6));
			dbMember.setShopImgUrl(rs.getString(7));
			dbMember.setShopMessage(rs.getString(8));
			AreaDao ad = new AreaDao();
			dbMember.setArea(ad.getArea(rs.getInt(9)));
		}
		rs.close();
		pstmt.close();
		con.close();
		return dbMember == null?null:dbMember;
	}
	
	public Member showShop(String shopId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where memberid=?";
		ResultSet rs = null;
		
		Member dbMember = new Member();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,shopId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			dbMember.setMemberId(rs.getString(1));
			dbMember.setMemberName(rs.getString(2));
			dbMember.setMemberPhone(rs.getString(3));
			dbMember.setMemberPassword(rs.getString(4));
			dbMember.setShopName(rs.getString(5));
			dbMember.setShopAdress(rs.getString(6));
			dbMember.setShopImgUrl(rs.getString(7));
			dbMember.setShopMessage(rs.getString(8));
			AreaDao ad = new AreaDao();
			dbMember.setArea(ad.getArea(rs.getInt(9)));
		}
		rs.close();
		pstmt.close();
		con.close();
		return dbMember == null?null:dbMember;
	}
	
	public Member getShopByProduct(String shopId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where memberid=?";
		ResultSet rs = null;
		
		Member dbMember = new Member();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,shopId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			dbMember.setMemberId(rs.getString(1));
			dbMember.setMemberName(rs.getString(2));
			dbMember.setMemberPhone(rs.getString(3));
			dbMember.setMemberPassword(rs.getString(4));
			dbMember.setShopName(rs.getString(5));
			dbMember.setShopAdress(rs.getString(6));
			dbMember.setShopImgUrl(rs.getString(7));
			dbMember.setShopMessage(rs.getString(8));
			AreaDao ad = new AreaDao();
			dbMember.setArea(ad.getArea(rs.getInt(9)));
		}
		rs.close();
		pstmt.close();
		con.close();
		return dbMember == null?null:dbMember;
	}
	public void shopRegister(Member member) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,member.getMemberId());
		pstmt.setString(2,member.getMemberName());
		pstmt.setString(3,member.getMemberPhone());
		pstmt.setString(4,member.getMemberPassword());
		pstmt.setString(5,member.getShopName());
		pstmt.setString(6,member.getShopAdress());
		pstmt.setString(7,member.getShopImgUrl());
		pstmt.setString(8,member.getShopMessage());
		pstmt.setInt(9,member.getArea().getAreaId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
}
