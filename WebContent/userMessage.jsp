<%@ page language="java" import="java.util.*,com.waimai.entity.*" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User) request.getSession().getAttribute("user");
%>

					<div> <% if(user != null) {%>
						<table class="table" style="margin-top:10px;width:500px;">							
							<tbody>
								<tr>
									<td>用户名：</td>
									<td><%=user.getUserNickName() %></td>
								</tr>
								<tr>
									<td>真实姓名：</td>
									<td><%=user.getUserTrueName() %></td>
								</tr>
								<tr>
									<td>手机：</td>
									<td><%=user.getUserPhone() %></td>
								</tr>
								<tr>
									<td>注册时间：</td>
									<td><%=user.getUserCreateTime() %></td>
								</tr>
								<tr>
									<td></td>
									<td>
										<button type="button" class="btn btn-info" style="width:150px;float:right;">修改</button>
									</td>
								</tr>
							</tbody>
						</table><% } %>
					</div>