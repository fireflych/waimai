package com.waimai.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waimai.entity.Comment;
import com.waimai.entity.Member;
import com.waimai.entity.Product;
import com.waimai.service.CommentService;
import com.waimai.service.ProductService;
import com.waimai.service.ShopService;

/**
 * Servlet implementation class showProduct
 */
@WebServlet("/showProduct")
public class showProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = new ProductService();
		ShopService shopService = new ShopService();
		CommentService commentService = new CommentService();
		List<Comment> comments = null;
		String productId = null;
		Product productdetail = null;
		Member shop = new Member();
		productId = (String) request.getAttribute("productid");
		if(productId != "")
		{
			try {
				productdetail = productService.showProduct(productId);
				if(productdetail != null) {
					shop = shopService.getShopByProduct(productdetail.getMember());
					comments = commentService.showCommentByProductId(productId);
					
					request.getSession().setAttribute("product", productdetail);
					request.getSession().setAttribute("shop", shop);
					request.getSession().setAttribute("comments", comments);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
