package com.waimai.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waimai.entity.Comment;
import com.waimai.entity.User;
import com.waimai.service.OrderManagerService;
import com.waimai.util.DateUtil;

/**
 * Servlet implementation class submitComment
 */
@WebServlet("/submitComment")
public class submitComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		String content = request.getParameter("content");
		String core = request.getParameter("core");
		String productId = request.getParameter("productid");
		String orderId = request.getParameter("orderid");
		OrderManagerService orderManagerService = new OrderManagerService();
		
		Comment comment = new Comment(content,new Float(core),DateUtil.getStringDate(),productId,user);
		
		try {
			orderManagerService.submitComment(comment, orderId);
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
