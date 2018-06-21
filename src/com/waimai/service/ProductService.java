package com.waimai.service;

import java.util.List;

import com.waimai.dao.ProductDao;
import com.waimai.entity.Area;
import com.waimai.entity.Category;
import com.waimai.entity.Member;
import com.waimai.entity.Product;

public class ProductService {

	public List<Product> showAllProducts() throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.getAllProducts();
	}
	public Product showProduct(String productId) throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.getProduct(productId);
	}
	public List<Category> getAllCategary() throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.getAllCategory();
	}
	public List<Area> getAllArea() throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.getAllArea();
	}
	public List<Product> showAllProducts(String type,Integer id) throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.showAllProductsByKind(type,id);
	}
	public List<Product> showAllProducts(String type,String id) throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.showAllProductsByKind(type,id);
	}
	public List<Product> showAProductsBySearch(String param) throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.showAProductsBySearch(param);
	}
	public List<Member> showAllShop() throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.showAllShop();
	}
	public Member showShop (String shopId) throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.showShop(shopId);
	}
	public List<Product> showProductsByShop(String shopId) throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.showProductsByShop(shopId);
	}
	public List<Product> showAProductsByShopId(String shopId) throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.showAProductsByShopId(shopId);
	}
	public List<Product> showProductsByOrder(String orderType) throws Exception{
		ProductDao productDao = new ProductDao();
		return productDao.showProductsByOrder(orderType);
	}
}
