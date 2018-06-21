package com.waimai.action;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waimai.entity.Member;
import com.waimai.entity.Product;
import com.waimai.service.ProductService;

/**
 * Servlet implementation class showCart
 */
@WebServlet("/showCart")
public class showCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member shop = new Member();
		List<Product> products = null;
		ProductService productService = new ProductService();
		String shopId = (String) request.getAttribute("shopid");
		
		try {
			shop = productService.showShop(shopId);
			products = productService.showProductsByShop(shop.getMemberId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Member> shops = (List<Member>) request.getSession().getAttribute("shops");
		shops.clear();
		request.setAttribute("shops", shops);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
