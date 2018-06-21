package com.waimai.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waimai.entity.Order;
import com.waimai.service.OrderManagerService;

/**
 * Servlet implementation class showOrderByOrderNum
 */
@WebServlet("/showOrderByOrderNum")
public class showOrderByOrderNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showOrderByOrderNum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		OrderManagerService orderManagerService = new OrderManagerService();
		Double totalPrice = new Double(0);
	    Boolean isComment = false;
	    String orderNum = (String) request.getAttribute("ordernum");
	    List<Order> orders = null;
		try {
			orders = orderManagerService.showOrdersByOrderNum(orderNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for(int i=0;i<orders.size();i++){
			totalPrice +=orders.get(i).getProductCount()*orders.get(i).getProductPrice();
		}
	    isComment = orders.get(0).getOrderIsComment();
	    request.getSession().setAttribute("orders", orders);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
