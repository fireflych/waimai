<%@ page language="java" import="java.util.*,com.waimai.entity.*" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Member member = (Member)request.getSession().getAttribute("shop");
List<Product> products = (List<Product>) request.getSession().getAttribute("products");
%>
<div> <% if( member != null ) {%>
						<table class="table table-hover">
							<thead>
							<tr>
								<th>商品名称</th>
								<th>现价</th>
								<th>原价</th>
								<th>销售量</th>
								<th>操作</th>
							</tr>
							</thead>
							<tbody>
							<% for(Product p: products) {%>
								<tr>
									<td><%=p.getProductName() %></td>
									<td><%=p.getProductCurrentPrize() %></td>
									<td><%=p.getProductOriginalPrize() %></td>
									<td><%=p.getProductSellNum() %></td>
									<td>修改</td>
								</tr>
							<% } %>
							</tbody>
						</table><%} %>
					</div>