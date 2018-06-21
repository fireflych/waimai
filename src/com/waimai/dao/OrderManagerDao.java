package com.waimai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.waimai.entity.Comment;
import com.waimai.entity.Order;
import com.waimai.entity.Product;

public class OrderManagerDao {
	
	public void submitComment(Comment comment,String orderId) throws Exception{
		List<Comment> commentList = new ArrayList<Comment>(); 
		List<Order> list = showOrdersByOrderNum(orderId);
		for(int i=0;i<list.size();i++){
			Comment c = new Comment(comment.getCommentContent(),comment.getCommentCore(), comment.getCommentDate(),list.get(i).getProductId(), comment.getUser());
			commentList.add(c);
		}
		for(int i=0;i<commentList.size();i++){
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "insert into comment values(?,?,?,?,?,?)";
			ResultSet rs = null;

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,commentList.get(i).getCommentId());
			pstmt.setString(2, commentList.get(i).getCommentContent());
			pstmt.setFloat(3, commentList.get(i).getCommentCore());
			pstmt.setString(4, commentList.get(i).getCommentDate());
			pstmt.setString(5, commentList.get(i).getProductId());
			pstmt.setString(6, commentList.get(i).getUser().getUserId());
			pstmt.executeUpdate();
			rs.close();
			pstmt.close();
			con.close();
		}
		for(int i=0;i<list.size();i++){
			String productId = list.get(i).getProductId();
			ProductDao pd = new ProductDao();
			Product p = pd.getProduct(productId);
			if(p!=null){
				Float core = p.getProductCore();
				Integer count = p.getProductSellNum();
				core = ((core*count)+comment.getCommentCore())/(count+1);
				pd.updateProductCore(productId, core);
			}
		}
		for(int i=0;i<list.size();i++){
			int orderid = list.get(i).getOrderId();
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "update product set orderiscomment=? where orderid=?";
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, true);
			pstmt.setInt(2, orderid);
			pstmt.executeUpdate();
		}
		
	}
	public List<Order> showOrdersByOrderNum(String orderNum) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM productorder WHERE orderNum=?";
		ResultSet rs = null;
		
		List<Order> oList = new ArrayList<Order>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,orderNum);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			Order order = new Order();
			order.setOrderId(rs.getInt(1));
			order.setOrderNum(rs.getString(2));
			order.setOrderPrice(rs.getFloat(3));
			order.setOrderIsComment(rs.getBoolean(4));
			order.setOrderDate(rs.getString(5));
			order.setProductId(rs.getString(6));
			order.setProductName(rs.getString(7));
			order.setProductPrice(rs.getFloat(8));
			order.setProductCount(rs.getInt(9));
			order.setMemberId(rs.getString(10));
			UserDao ud = new UserDao();
			order.setUser(ud.showUser(rs.getString(11)));
			oList.add(order);
		}
		rs.close();
		pstmt.close();
		con.close();
		return oList;
	}

	public List<Order> showOrdersByUser(String userId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM productorder WHERE user=? GROUP BY ordernum";
		ResultSet rs = null;
		
		List<Order> oList = new ArrayList<Order>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,userId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			Order order = new Order();
			order.setOrderId(rs.getInt(1));
			order.setOrderNum(rs.getString(2));
			order.setOrderPrice(rs.getFloat(3));
			order.setOrderIsComment(rs.getBoolean(4));
			order.setOrderDate(rs.getString(5));
			order.setProductId(rs.getString(6));
			order.setProductName(rs.getString(7));
			order.setProductPrice(rs.getFloat(8));
			order.setProductCount(rs.getInt(9));
			order.setMemberId(rs.getString(10));
			UserDao ud = new UserDao();
			order.setUser(ud.showUser(rs.getString(11)));
			oList.add(order);
		}
		rs.close();
		pstmt.close();
		con.close();
		return oList;
	}
	
	public List<Order> showOrdersByShop(String shopId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM productorder WHERE memberid=? GROUP BY ordernum";
		ResultSet rs = null;
		
		List<Order> oList = new ArrayList<Order>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, shopId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			Order order = new Order();
			order.setOrderId(rs.getInt(1));
			order.setOrderNum(rs.getString(2));
			order.setOrderPrice(rs.getFloat(3));
			order.setOrderIsComment(rs.getBoolean(4));
			order.setOrderDate(rs.getString(5));
			order.setProductId(rs.getString(6));
			order.setProductName(rs.getString(7));
			order.setProductPrice(rs.getFloat(8));
			order.setProductCount(rs.getInt(9));
			order.setMemberId(rs.getString(10));
			UserDao ud = new UserDao();
			order.setUser(ud.showUser(rs.getString(11)));
			oList.add(order);
		}
		rs.close();
		pstmt.close();
		con.close();
		return oList;
	}
	public void updateOrder(Order order) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update productorder set ordernum=?,orderprice=?,orderiscomment=?,orderdate=?,"
				+ "productid=?,productname=?,productprice=?,productcount=?,memberid=?,user=?";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, order.getOrderNum());
		pstmt.setFloat(2, order.getOrderPrice());
		pstmt.setBoolean(3, order.getOrderIsComment());
		pstmt.setString(4, order.getOrderDate());
		pstmt.setString(5, order.getProductId());
		pstmt.setString(6, order.getProductName());
		pstmt.setFloat(7, order.getProductPrice());
		pstmt.setInt(8, order.getProductCount());
		pstmt.setString(9, order.getMemberId());
		pstmt.setString(10, order.getUser().getUserId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	}
}
