package com.waimai.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waimai.entity.User;
import com.waimai.service.ShopService;
import com.waimai.service.UserService;
import com.waimai.util.DateUtil;
import com.waimai.util.UuidUtil;

/**
 * Servlet implementation class userRegister
 */
@WebServlet("/userRegister")
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		String userPhone;
		String userPassword;
		String registerState;
		
		userPhone = request.getParameter("userPhone");
		userPassword = request.getParameter("userPassword");
		
		User user = new User(UuidUtil.getUUID(),userPhone,userPassword,userPhone,DateUtil.getStringDate());
		try {
			userService.userRegister(user);
			registerState = "success";
			request.getSession().setAttribute("user", user);
		} catch (ClassNotFoundException | SQLException e) {
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
