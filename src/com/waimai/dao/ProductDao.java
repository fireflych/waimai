package com.waimai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.waimai.entity.Area;
import com.waimai.entity.Category;
import com.waimai.entity.Member;
import com.waimai.entity.Product;
import com.waimai.entity.User;

public class ProductDao {

	/**
	 * 获取全部物品
	 * @return List<Product>
	 * @throws Exception 
	 */
	public List<Product> getAllProducts() throws Exception{
		
		Connection con = null;
		Statement stmt = null;
		String sql = "select * from product";
		ResultSet rs = null;
		
		List<Product> pList = new ArrayList<Product>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			Product product = new Product();
			product.setProductId(rs.getString(1));
			product.setProductName(rs.getString(2));
			product.setProductSubtitle(rs.getString(3));
			product.setProductOriginalPrize(rs.getFloat(4));
			product.setProductSellNum(rs.getInt(5));
			product.setProductCore(rs.getFloat(6));
			product.setProductCurrentPrize(rs.getFloat(7));
			product.setProductImgUrl(rs.getString(8));
			CategoryDao cd = new CategoryDao();
			product.setCategory(cd.getCategory(rs.getInt(9)));
			ShopDao sd = new ShopDao();
			product.setMember(sd.getShopByProduct(rs.getString(10)));
			pList.add(product);
		}
		rs.close();
		stmt.close();
		con.close();
		return pList;
	}
	
	public Product getProduct(String productId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from product where productid=?";
		ResultSet rs = null;
		
		Product product = new Product();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, productId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			product.setProductId(rs.getString(1));
			product.setProductName(rs.getString(2));
			product.setProductSubtitle(rs.getString(3));
			product.setProductOriginalPrize(rs.getFloat(4));
			product.setProductSellNum(rs.getInt(5));
			product.setProductCore(rs.getFloat(6));
			product.setProductCurrentPrize(rs.getFloat(7));
			product.setProductImgUrl(rs.getString(8));
			CategoryDao cd = new CategoryDao();
			product.setCategory(cd.getCategory(rs.getInt(9)));
			ShopDao sd = new ShopDao();
			product.setMember(sd.getShopByProduct(rs.getString(10)));
		}
		rs.close();
		pstmt.close();
		con.close();
		return product;
	}
	public List<Product> showAProductsByShopId(String shopId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from product where member=?";
		ResultSet rs = null;
		
		List<Product> pList = new ArrayList<Product>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, shopId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			Product product = new Product();
			product.setProductId(rs.getString(1));
			product.setProductName(rs.getString(2));
			product.setProductSubtitle(rs.getString(3));
			product.setProductOriginalPrize(rs.getFloat(4));
			product.setProductSellNum(rs.getInt(5));
			product.setProductCore(rs.getFloat(6));
			product.setProductCurrentPrize(rs.getFloat(7));
			product.setProductImgUrl(rs.getString(8));
			CategoryDao cd = new CategoryDao();
			product.setCategory(cd.getCategory(rs.getInt(9)));
			ShopDao sd = new ShopDao();
			product.setMember(sd.getShopByProduct(rs.getString(10)));
			pList.add(product);
		}
		rs.close();
		pstmt.close();
		con.close();
		return pList;
	}
	public List<Category> getAllCategory() throws Exception{
		Connection con = null;
		Statement stmt = null;
		String sql = "select * from category";
		ResultSet rs = null;
		
		List<Category> cList = new ArrayList<Category>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			Category category = new Category();
			category.setCategoryId(rs.getInt(1));
			category.setCategoryName(rs.getString(2));
			cList.add(category);
		}
		rs.close();
		stmt.close();
		con.close();
		return cList;
	}
	public List<Area> getAllArea() throws Exception{
		Connection con = null;
		Statement stmt = null;
		String sql = "select * from area";
		ResultSet rs = null;
		
		List<Area> aList = new ArrayList<Area>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			Area area = new Area();
			area.setAreaId(rs.getInt(1));
			area.setAreaName(rs.getString(2));
			aList.add(area);
		}
		rs.close();
		stmt.close();
		con.close();
		return aList;
	}
	
	public List<Product> showAllProductsByKind(String type,Integer id) throws Exception{
		List<Product> p = null;
		if("category".equals(type)){	
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "select * from product where category=?";
			ResultSet rs = null;
			
			List<Product> pList = new ArrayList<Product>();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductSubtitle(rs.getString(3));
				product.setProductOriginalPrize(rs.getFloat(4));
				product.setProductSellNum(rs.getInt(5));
				product.setProductCore(rs.getFloat(6));
				product.setProductCurrentPrize(rs.getFloat(7));
				product.setProductImgUrl(rs.getString(8));
				CategoryDao cd = new CategoryDao();
				product.setCategory(cd.getCategory(rs.getInt(9)));
				ShopDao sd = new ShopDao();
				product.setMember(sd.getShopByProduct(rs.getString(10)));
				pList.add(product);
			}
			rs.close();
			pstmt.close();
			con.close();
			
			p = pList;
		}else if ("area".equals(type)) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "select * from product left join member on product.member=member.memberid where area=?"+id;
			ResultSet rs = null;
			
			List<Product> pList = new ArrayList<Product>();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Product product = new Product();
				product.setProductId(rs.getString("productid"));
				product.setProductName(rs.getString("productname"));
				product.setProductSubtitle(rs.getString("productsubtitle"));
				product.setProductOriginalPrize(rs.getFloat("productoriginalprize"));
				product.setProductSellNum(rs.getInt("productsellnum"));
				product.setProductCore(rs.getFloat("productcore"));
				product.setProductCurrentPrize(rs.getFloat("productcurrentprize"));
				product.setProductImgUrl(rs.getString("productimgurl"));
				CategoryDao cd = new CategoryDao();
				product.setCategory(cd.getCategory(rs.getInt("category")));
				ShopDao sd = new ShopDao();
				product.setMember(sd.getShopByProduct(rs.getString("member")));
				pList.add(product);
			}
			rs.close();
			pstmt.close();
			con.close();
			
			p = pList;
		}else{
			return null;
		}
		return p;
	}
	public List<Product> showAllProductsByKind(String type,String id) throws Exception{
			Connection con = null;
			Statement stmt = null;
			String sql = "select * from product where member="+id;
			ResultSet rs = null;
			
			List<Product> pList = new ArrayList<Product>();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductSubtitle(rs.getString(3));
				product.setProductOriginalPrize(rs.getFloat(4));
				product.setProductSellNum(rs.getInt(5));
				product.setProductCore(rs.getFloat(6));
				product.setProductCurrentPrize(rs.getFloat(7));
				product.setProductImgUrl(rs.getString(8));
				CategoryDao cd = new CategoryDao();
				product.setCategory(cd.getCategory(rs.getInt(9)));
				ShopDao sd = new ShopDao();
				product.setMember(sd.getShopByProduct(rs.getString(10)));
				pList.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
		return pList;
	}
	public List<Product> showAProductsBySearch(String param) throws Exception{
		if(param !=null){
			Connection con = null;
			Statement stmt = null;
			String sql = "select * from product where productname like '%"+param+"%'";
			ResultSet rs = null;
			
			List<Product> pList = new ArrayList<Product>();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductSubtitle(rs.getString(3));
				product.setProductOriginalPrize(rs.getFloat(4));
				product.setProductSellNum(rs.getInt(5));
				product.setProductCore(rs.getFloat(6));
				product.setProductCurrentPrize(rs.getFloat(7));
				product.setProductImgUrl(rs.getString(8));
				CategoryDao cd = new CategoryDao();
				product.setCategory(cd.getCategory(rs.getInt(9)));
				ShopDao sd = new ShopDao();
				product.setMember(sd.getShopByProduct(rs.getString(10)));
				pList.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
			return pList;
		}else{
			return null;
		}
	}
	public List<Member> showAllShop() throws Exception{
		Connection con = null;
		Statement stmt = null;
		String sql = "select * from member";
		ResultSet rs = null;
		
		List<Member> mList = new ArrayList<Member>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		stmt = con.createStatement();	
		rs = stmt.executeQuery(sql);
		if(rs.next())
		{
			Member dbMember = new Member();
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
			mList.add(dbMember);
		}
		rs.close();
		stmt.close();
		con.close();
		return mList;
	}
	public Member showShop (String shopId) throws Exception{
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
	
	public List<Product> showProductsByShop(String shopId) throws Exception{	
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from product where member=?";
		ResultSet rs = null;
		
		List<Product> pList = new ArrayList<Product>();
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, shopId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			Product product = new Product();
			product.setProductId(rs.getString(1));
			product.setProductName(rs.getString(2));
			product.setProductSubtitle(rs.getString(3));
			product.setProductOriginalPrize(rs.getFloat(4));
			product.setProductSellNum(rs.getInt(5));
			product.setProductCore(rs.getFloat(6));
			product.setProductCurrentPrize(rs.getFloat(7));
			product.setProductImgUrl(rs.getString(8));
			CategoryDao cd = new CategoryDao();
			product.setCategory(cd.getCategory(rs.getInt(9)));
			ShopDao sd = new ShopDao();
			product.setMember(sd.getShopByProduct(rs.getString(10)));
			pList.add(product);
		}
		rs.close();
		pstmt.close();
		con.close();
		return pList;
	}
	public List<Product> showProductsByOrder(String orderType) throws Exception{
		List<Product> p = null;
		
		if("sell".equals(orderType)){
			Connection con = null;
			Statement stmt = null;
			String sql = "select * from product order by productsellnum desc";
			ResultSet rs = null;
			
			List<Product> pList = new ArrayList<Product>();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductSubtitle(rs.getString(3));
				product.setProductOriginalPrize(rs.getFloat(4));
				product.setProductSellNum(rs.getInt(5));
				product.setProductCore(rs.getFloat(6));
				product.setProductCurrentPrize(rs.getFloat(7));
				product.setProductImgUrl(rs.getString(8));
				CategoryDao cd = new CategoryDao();
				product.setCategory(cd.getCategory(rs.getInt(9)));
				ShopDao sd = new ShopDao();
				product.setMember(sd.getShopByProduct(rs.getString(10)));
				pList.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
			p = pList;
		}else if ("price".equals(orderType)) {
			Connection con = null;
			Statement stmt = null;
			String sql = "select * from product order by productcurrentprize asc";
			ResultSet rs = null;
			
			List<Product> pList = new ArrayList<Product>();
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductSubtitle(rs.getString(3));
				product.setProductOriginalPrize(rs.getFloat(4));
				product.setProductSellNum(rs.getInt(5));
				product.setProductCore(rs.getFloat(6));
				product.setProductCurrentPrize(rs.getFloat(7));
				product.setProductImgUrl(rs.getString(8));
				CategoryDao cd = new CategoryDao();
				product.setCategory(cd.getCategory(rs.getInt(9)));
				ShopDao sd = new ShopDao();
				product.setMember(sd.getShopByProduct(rs.getString(10)));
				pList.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
			p = pList;
		}
		else
			return null;
		return p;
	}
	
	
	public void updateProductCore(String productid,float core) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update product set productcore=? where productid=?";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		pstmt = con.prepareStatement(sql);
		pstmt.setFloat(1, core);
		pstmt.setString(2, productid);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}
