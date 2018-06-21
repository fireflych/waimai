package com.waimai.service;

import com.waimai.dao.ShopDao;
import com.waimai.entity.Member;

public class ShopService {
	
	public Member shopLogin(String userPhone,String userPassword) throws Exception{
		ShopDao shopDao = new ShopDao();
		Member m = shopDao.shopLogin(userPhone,userPassword);
		m.setMemberPassword("");
		return m;
	}
	public Member getShopByProduct(Member shop) throws Exception{
		ShopDao shopDao = new ShopDao();
		return shopDao.getShopByProduct(shop.getMemberId());
	}
	public Member showShop(String shopId) throws Exception{
		ShopDao shopDao = new ShopDao();
		return shopDao.showShop(shopId);
	}
	public void shopRegister(Member member) throws Exception{
		ShopDao shopDao = new ShopDao();
		shopDao.shopRegister(member);
	}


	
}
