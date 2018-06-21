package com.waimai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.waimai.entity.Comment;
import com.waimai.entity.Product;

public class CommentDao {

	
	public List<Comment> showCommentByProductId(String productId) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from comment where productid=?";
		ResultSet rs = null;
		
		List<Comment> cList = new ArrayList<Comment>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, productId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			Comment comment = new Comment();
			comment.setCommentId(rs.getInt(1));
			comment.setCommentContent(rs.getString(2));
			comment.setCommentCore(rs.getFloat(3));
			comment.setCommentDate(rs.getString(4));
			comment.setProductId(rs.getString(5));
			UserDao ud = new UserDao();
			comment.setUser(ud.showUser(rs.getString(6)));
			cList.add(comment);
		}
		rs.close();
		pstmt.close();
		con.close();
		return cList;
	}
}
