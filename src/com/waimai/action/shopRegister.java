package com.waimai.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waimai.entity.Area;
import com.waimai.entity.Member;
import com.waimai.service.ShopService;
import com.waimai.util.UuidUtil;

/**
 * Servlet implementation class shopRegister
 */
@WebServlet("/shopRegister")
public class shopRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopService shopService = new ShopService();
		String memberName=null;
		String memberPhone=null;
		String shopName=null;
		String shopAdress=null;
		String shopImgUrl=null;
		String shopMessage=null;
		Area area=new Area(1);
		
		memberName = request.getParameter("memberName");
		memberPhone = request.getParameter("memberPhone");
		shopName = request.getParameter("shopName");
		shopAdress = request.getParameter("shopAdress");
		shopImgUrl = request.getParameter("shopImgUrl");
		shopMessage = request.getParameter("shopMessage");
		
		Member member = new Member(UuidUtil.getUUID(), memberName, memberPhone, shopName, shopAdress, shopImgUrl, shopMessage, area);
		try {
			shopService.shopRegister(member);
			request.getSession().getAttribute("member");
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
