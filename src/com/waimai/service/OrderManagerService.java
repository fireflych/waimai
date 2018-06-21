package com.waimai.service;

import java.util.List;

import com.waimai.dao.OrderManagerDao;
import com.waimai.entity.Comment;
import com.waimai.entity.Order;
import com.waimai.entity.Product;

public class OrderManagerService {
	private OrderManagerDao orderManagerDao;
	
	public void submitComment(Comment comment,String orderId) throws Exception{
		orderManagerDao.submitComment(comment,orderId);
	}
	public List<Order> showOrdersByUser(String userId) throws Exception{
		return orderManagerDao.showOrdersByUser(userId);
	}
	public List<Order> showOrdersByOrderNum(String orderNum) throws Exception{
		return orderManagerDao.showOrdersByOrderNum(orderNum);
	}
	public List<Order> showOrdersByShop(String shopId) throws Exception{
		return orderManagerDao.showOrdersByShop(shopId);
	}

	public OrderManagerDao getOrderManagerDao() {
		return orderManagerDao;
	}

	public void setOrderManagerDao(OrderManagerDao orderManagerDao) {
		this.orderManagerDao = orderManagerDao;
	}
	
	
}
