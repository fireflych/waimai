<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
			<s:iterator value="orders" var="o">
			<tr class="trline">
				<td style="text-align: left;padding-left:10px;">
				${o.productName }
				</td>
				<td>¥<span>${o.productPrice}</span></td>
				<td >${o.productCount}份</td>
				<td ><span class="fonttored">¥${o.productCount * o.productPrice}</span></td>
			</tr>
			</s:iterator>	
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
		</div>
	</div>
