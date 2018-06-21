package com.waimai.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.waimai.entity.FromPageCart;
import com.waimai.entity.Order;
import com.waimai.entity.User;
import com.waimai.service.PayService;
import com.waimai.util.DateUtil;
import com.waimai.util.UuidUtil;

/**
 * Servlet implementation class pay
 */
@WebServlet("/pay")
public class pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PayService payService = new PayService();
		String cartparam;
		String shopId;
		
		ObjectMapper mapper = new ObjectMapper();
		cartparam = (String) request.getAttribute("cartparam");
		shopId = (String) request.getAttribute("shopid");
		
		FromPageCart[] cart = mapper.readValue(cartparam, FromPageCart[].class);
		List<Order> orders = new ArrayList<Order>();
		String uuid = UuidUtil.getUUID();
		
		User u = (User) request.getSession().getAttribute("user");
		Float price = new Float(0);
		if(u != null) {
			for(int i=0;i<cart.length;i++){
				orders.add(new Order(uuid, new Float(0), false, DateUtil.getStringDate(), cart[i].getPageCartId(), cart[i].getPageCartName(),shopId,u));
				orders.get(i).setProductCount(Integer.parseInt(cart[i].getPageCartCount()));
				orders.get(i).setProductName(cart[i].getPageCartName());
				orders.get(i).setProductPrice(Float.parseFloat(cart[i].getPageCartPrice()));
				price += Integer.parseInt(cart[i].getPageCartCount())*Float.parseFloat(cart[i].getPageCartPrice());
			}
		}else{
			for(int i=0;i<cart.length;i++){
				orders.add(new Order(uuid, new Float(0), false, DateUtil.getStringDate(), cart[i].getPageCartId(),cart[i].getPageCartName(),shopId));
				orders.get(i).setProductCount(Integer.parseInt(cart[i].getPageCartCount()));
				orders.get(i).setProductName(cart[i].getPageCartName());
				orders.get(i).setProductPrice(Float.parseFloat(cart[i].getPageCartPrice()));
				price += Integer.parseInt(cart[i].getPageCartCount())*Float.parseFloat(cart[i].getPageCartPrice());
			}
		}
		for(int i=0;i<orders.size();i++){
			orders.get(i).setOrderPrice(price);
		}
		try {
			payService.pay(orders);
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
