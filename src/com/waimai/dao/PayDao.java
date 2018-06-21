package com.waimai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.waimai.entity.Order;
import com.waimai.entity.Product;

public class PayDao {
	
	public void pay(List<Order> orders) throws Exception{
		for(int i=0;i<orders.size();i++){
			OrderManagerDao omd = new OrderManagerDao();
			omd.updateOrder(orders.get(i));
			ProductDao pd = new ProductDao();
			Product p = pd.getProduct(orders.get(i).getProductId());
			
			p.setProductSellNum( p.getProductSellNum()+orders.get(i).getProductCount());
			
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "update product set productsellnum=? where productid=?";
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p.getProductSellNum());
			pstmt.setString(2, p.getProductId());
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}
	}
}
