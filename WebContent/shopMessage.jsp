<%@ page language="java" import="java.util.*,com.waimai.entity.*" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Member shop = (Member) request.getSession().getAttribute("shop");
%>

					<div> <% if(shop != null) {%>
					<div class="col-md-6">
						<table class="table" style="margin-top:10px;width:500px;">							
							<tbody>
								<tr>
									<td>商店名：</td>
									<td><%=shop.getShopName() %></td>
								</tr>
								<tr>
									<td>地址：</td>
									<td><%=shop.getShopAdress() %></td>
								</tr>
								<tr>
									<td>公告：</td>
									<td><%=shop.getShopMessage() %></td>
								</tr>
								<tr>
									<td>负责人：</td>
									<td><%=shop.getMemberName() %></td>
								</tr>
								<tr>
									<td>负责人电话：</td>
									<td><%=shop.getMemberPhone() %></td>
								</tr>
								<tr>
									<td></td>
									<td>
									</td>
								</tr>
							</tbody>
						</table>
						</div>
						<div class="col-md-6"><img  src="<%= shop.getShopImgUrl() %>" style="width:180px;height:130px;margin-left:70px;margin-top:10px;"class="img-thumbnail">
						<br><button type="button" class="btn btn-info" style="width:180px;margin-left:70px;margin-top:7px;">修改</button>
						</div>
						<% } %>
					</div>