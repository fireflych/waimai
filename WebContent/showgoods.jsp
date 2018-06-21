<%@ page language="java" import="java.util.*,com.waimai.entity.*" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Product> products = (List<Product>) request.getSession().getAttribute("products");
%>
	<% for(Product p: products) { %>
			<div class="col-md-3 aa ">
					
						<div class="good-hover"style="padding-top:20px;margin-top:10px;margin-bottom:10px"> 
							<a href="#/detail/<%=p.getProductId()%>">
							<div class="preview center-block"> <!-- 图片 208 156-->
								<img src="<%=p.getProductImgUrl() %>" style="width: 228px; height: 171px;" class="img-rounded">
							</div>
							<div class="content center-block">
								<dl style="margin-bottom:10px">
								<div class="name">
									<span> <dt class="good-tittle"><%=p.getProductName() %></dt></span>
								</div>
								<div class="describe">
									<dd class="describe-font"><%= p.getProductSubtitle() %></dd>
								</div>
								</dl>
								<div class="rank">
									<span class="star black-star">
										<span class="star-score" style="width: {<%=p.getProductCore() %>*14.4}}px"></span>
									</span>
									<span class="describe-font"><%=p.getProductCore() %>分</span>
									<span class="fr" style="color: #fa9700;">已售<%=p.getProductSellNum() %>单</span>
								</div>
								<div class="prize">
									<span><span class="sell-prize" style="color: #f76120;">&yen;<%=p.getProductCurrentPrize() %></span><span class="describe-font">&nbsp;门店价&nbsp;<del>&yen;<%=p.getProductOriginalPrize() %></del></span></span>
								</div>
							</div>
							</a>
						</div>
						
			</div>
			<% } %>
			
			