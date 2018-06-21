<%@ page language="java" import="java.util.*,com.waimai.entity.*" pageEncoding="UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Order> orders = (List<Order>) request.getSession().getAttribute("orders");
%>
	<div class="aa"style="margin-bottom:16px;margin-left:20px;margin-right:18px;" >
	
		<div class="row cannot_select" style="" > <!-- 第三行 -->
		<table class="order" style="text-align: center;width: 100%;">
			<tr>
			<th style="text-align: left;">项目</th>
			<th class="unit-price">单价</th>
			<th class="amount">数量</th>
			<th class="col-total">总价</th>
			</tr>
			<% for(Order o:orders) { %>
			<tr class="trline">
				<td style="text-align: left;padding-left:10px;">
				${o.productName } <%= o.getProductName() %>
				</td>
				<td>¥<span><%=o.getProductPrice() %></span></td>
				<td >><%=o.getProductCount()%>份</td>
				<td ><span class="fonttored"><%= o.getProductCount() * o.getProductPrice() %></span></td>
			</tr>
			<% } %>	
			<tr class="trline">
			<td></td>
			<td class="extra-fee total-fee rightpadding" style="text-align: right;padding-right:45px;" colspan="3">
			<strong>总金额</strong>
			：
			<span class="inline-block money">
			
			<strong  class="fonttored">¥${totalPrice}</strong>
			</span>
			</td>
			</tr>			
			</table>
			<% if(orders.get(1).getOrderIsComment() == true) {%>
			
			<% }else{ %>
			
			<div style="font-size:14px;" ng-controller="commentCtrl">
			<form ng-submit="addComment(comment,'${orderNum}')" method="post" name="commentform">
			<div  style="margin-top:10px;">
				<strong>评分：</strong> 
				<select class="form-control" style="width:100px;display: inline-block;font-size:12px;" name="core" ng-model="comment.core">
				  <option value="1">差</option>
				  <option value="2">一般</option>
				  <option value="3">满意</option>
				  <option value="4">很满意</option>
				  <option value="5">强烈推荐</option>
				</select>
			</div>
			<br>
			<div>
				评价内容：
				<br/><br/>
				<textarea class="form-control" style="resize:none;" rows="3" ng-model="comment.content" name="content"></textarea>
				<br>
				<button type="submit" class="btn btn-info" style="width:150px;">提交评价</button>
			</div>
			</form>
			</div>
			<% } %>
		</div>
	</div>
