<%@ page language="java" import="java.util.List,com.waimai.entity.*"contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Category> categorys = (List<Category>) request.getSession().getAttribute("categorys");
List<Area> areas = (List<Area>) request.getSession().getAttribute("areas");
%>
<div class="aa"style="margin-bottom:16px;margin-left:-15px;margin-right:-15px;">
	<div class="row cannot_select"> <!-- 第三行 -->
		<div class="col-md-2 ">
			<span class="glyphicon glyphicon-cutlery category">&nbsp;<strong class="category-font">热门订餐</strong></span>
		</div>
		<div class="col-md-10 ">
			<ul class="list-unstyled list-inline fontsize14">
				<% for(Category c: categorys) {%>
				<li><a href="#/allgoods/category/<%= c.getCategoryId() %>>"><%= c.getCategoryName() %></a></li>
				<% } %>>
			</ul>			  
		</div>
	</div>

	<div class="row cannot_select"> <!-- 第四行 -->
		<div class="col-md-2 ">
			<span class="glyphicon glyphicon-map-marker category">&nbsp;<strong class="category-font">全部区域</strong></span>
		</div>
		<div class="col-md-10 ">
			<ul class="list-unstyled list-inline fontsize14">
				<% for(Area a: areas ) { %>>
				<li><a href="#/allgoods/area/<%= a.getAreaId() %>"><%= a.getAreaName() %></a></li>
				<%} %>
			</ul>		
		</div>
	</div>
	</div>
	<div class="row good-list-line"> <!-- 第五行 -->
		<div class="col-md-12 aa">		
		<div style="padding-left:15px;margin-top:9px">	
			<ul class="list-unstyled list-inline cannot_select sort">
				<li><a href="#/allgoods"><span>默认排序</span></a>&nbsp;&nbsp;</li>
				<li><a href="#/allgoods/order/sell">销量&nbsp;<span style="background-image: url('images/icons_01.png');background-position: -371px -40px">&nbsp;&nbsp;&nbsp;</span></a>&nbsp;</li>
				<li><a href="#/allgoods/order/price">价格&nbsp;<span style="background-image: url('images/icons_01.png');background-position: -397px -40px">&nbsp;&nbsp;&nbsp;</span></a>&nbsp;</li>
			</ul>	
		</div>	
		</div>
	</div>
	<div class="aa" >  <!-- 开始展示商品 -->
		<div class="row aa" > <!-- 第一行 style="padding-left:32.25px;oadding-right:32.25"-->
		<div ui-view="showgoods"></div>
			
		</div>
		<div class="good-line"></div>		
	</div>