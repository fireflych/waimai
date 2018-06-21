package com.waimai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.waimai.entity.Area;
import com.waimai.entity.User;

public class AreaDao {
	
	
	public AreaDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Area getArea(int areaId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from area where areaid=?";
		ResultSet rs = null;
		
		Area area = new Area();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,areaId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			area.setAreaId(rs.getInt(1));
			area.setAreaName(rs.getString(2));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return area == null?null:area;
	}

	public void setArea(Area area) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into area values(?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,area.getAreaId());
		pstmt.setString(2,area.getAreaName());

		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	
}
