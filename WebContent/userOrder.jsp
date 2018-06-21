<%@ page language="java" import="java.util.*,com.waimai.entity.*" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User) request.getSession().getAttribute("user");
List<Order> orders = (List<Order>) request.getSession().getAttribute("orders");
%>
<div> <% if(user != null) {%>
						<table class="table table-hover">
							<thead>
							<tr>
								<th>订单名称</th>
								<th>数量</th>
								<th>总价</th>
								<th>评价</th>
							</tr>
							</thead>
							<tbody>
							<% for(Order o: orders) {%>
								<tr>
									<td><a href="#/myMessage/showUserOrder/<%=o.getOrderNum() %>"><%=o.getProductName() %>等...</a></td>
									<td><%=o.getProductCount() %>1份</td>
									<td><%=o.getOrderPrice() %></td>
									<td><% if(o.getOrderIsComment() == true) {%>已评价<% } else {%>未评价<%} %> </td>
								</tr>
							<% } %>
							</tbody>
						</table><% }%>
					</div>