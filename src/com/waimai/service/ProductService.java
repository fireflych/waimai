package com.waimai.service;

import java.util.List;

import com.waimai.dao.ProductDao;
import com.waimai.entity.Area;
import com.waimai.entity.Category;
import com.waimai.entity.Member;
import com.waimai.entity.Product;

public class ProductService {

	private ProductDao productDao;

	public List<Product> showAllProducts() throws Exception{
		return productDao.getAllProducts();
	}
	public Product showProduct(String productId) throws Exception{
		return productDao.getProduct(productId);
	}
	public List<Category> getAllCategary() throws Exception{
		return productDao.getAllCategory();
	}
	public List<Area> getAllArea() throws Exception{
		return productDao.getAllArea();
	}
	public List<Product> showAllProducts(String type,Integer id) throws Exception{
		return productDao.showAllProductsByKind(type,id);
	}
	public List<Product> showAllProducts(String type,String id) throws Exception{
		return productDao.showAllProductsByKind(type,id);
	}
	public List<Product> showAProductsBySearch(String param) throws Exception{
		return productDao.showAProductsBySearch(param);
	}
	public List<Member> showAllShop() throws Exception{
		return productDao.showAllShop();
	}
	public Member showShop (String shopId) throws Exception{
		return productDao.showShop(shopId);
	}
	public List<Product> showProductsByShop(String shopId) throws Exception{
		return productDao.showProductsByShop(shopId);
	}
	public List<Product> showAProductsByShopId(String shopId) throws Exception{
		return productDao.showAProductsByShopId(shopId);
	}
	public List<Product> showProductsByOrder(String orderType) throws Exception{
		return productDao.showProductsByOrder(orderType);
	}
/*
 * ===========================Getter  Setter mothod=====================================
 */
	public ProductDao getProductDao() {
		return productDao;
	}



	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
}
