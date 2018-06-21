package com.waimai.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waimai.service.ShopService;
import com.waimai.entity.Member;

/**
 * Servlet implementation class shopLogin
 */
@WebServlet("/shopLogin")
public class shopLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopLoginState;
		Member shop;
		String shopPhone = null;
		String shopPassword = null;
		ShopService shopService = null;
		
		shopLoginState="";
		shopService = new ShopService();
		shopPhone = request.getParameter("shopPhone");
		shopPassword = request.getParameter("shopPassword");
		try {
			Member m = shopService.shopLogin(shopPhone,shopPassword);
			request.getSession().setAttribute("shop", m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
