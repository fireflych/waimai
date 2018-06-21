package com.waimai.service;

import java.util.List;

import com.waimai.dao.PayDao;
import com.waimai.entity.Order;

public class PayService {
	private PayDao payDao;

	
	
	public PayService() {
		super();
		this.payDao = new PayDao();
	}
	public void pay(List<Order> orders) throws Exception{
		payDao.pay(orders);
	}
	public PayDao getPayDao() {
		return payDao;
	}

	public void setPayDao(PayDao payDao) {
		this.payDao = payDao;
	}
	
	
}
