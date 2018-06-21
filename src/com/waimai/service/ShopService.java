package com.waimai.service;

import com.waimai.dao.ShopDao;
import com.waimai.entity.Member;

public class ShopService {
	private ShopDao shopDao;
	
	public Member shopLogin(String userPhone,String userPassword) throws Exception{
		Member m = shopDao.shopLogin(userPhone,userPassword);
		m.setMemberPassword("");
		return m;
	}
	public Member getShopByProduct(Member shop) throws Exception{
		
		return shopDao.getShopByProduct(shop.getMemberId());
	}
	public Member showShop(String shopId) throws Exception{
		return shopDao.showShop(shopId);
	}
	public void shopRegister(Member member) throws Exception{
		shopDao.shopRegister(member);
	}
	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	
}
