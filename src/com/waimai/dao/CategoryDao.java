package com.waimai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.waimai.entity.Area;
import com.waimai.entity.Category;

public class CategoryDao {

	public CategoryDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category getCategory(int caterogyid) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from category where category=?";
		ResultSet rs = null;
		
		Category category = new Category();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,caterogyid);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			category.setCategoryId(rs.getInt(1));
			category.setCategoryName(rs.getString(2));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return category == null?null:category;
	}
	
	public void setCategory(Category caterogy) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into category values(?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,caterogy.getCategoryId());
		pstmt.setString(2,caterogy.getCategoryName());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
}
