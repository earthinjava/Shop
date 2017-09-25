<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="head">
	<div class="log">
		<ul class="log_ul">
			<%
				if (session.getAttribute("username") == null) {
			%>
			<li><a  style="display:block; margin-right:10px;" href="<%=request.getContextPath()%>/user?method=loginUI">登录</a>
			</li>
			<li><a style="display:block; margin-right:10px;" 
				href="<%=request.getContextPath()%>/user?method=registerUI">注册</a></li>
			<%
				} else if (session.getAttribute("username") != null) {
			%>
			<li><a  style="display:block; margin-right:10px;" href="<%=request.getContextPath()%>/user?method=showuser"><%=session.getAttribute("username")%>，您好</a></li>
			<li><a  style="display:block; margin-right:10px;" href="<%=request.getContextPath()%>/user?method=logout">退出</a></li>

			<%
				}
			%>
			<li><a style="display:block; margin-right:10px;" href="<%=request.getContextPath()%>/order?method=findMyOrdersByPage&pageNumber=1">订单</a></li>	
			<li><a style="display:block; margin-right:10px;"  href="<%=request.getContextPath()%>/jsp/cart.jsp">购物车</a></li>			
		</ul>
	</div>
	<div class="category">
		<ul class="category_ul">
		<li><a class="head" href="${pageContext.request.contextPath }">首页</a></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//发送AJAX请求，查询分类
						//发送请求url，发送请求参数，请求响应获得响应后执行回调函数
						$
								.post(
										"${pageContext.request.contextPath}/category",
										{
											"method" : "findAll"
										},
										function(result) {
											$(result)
													.each(
															function() {
																$("ul.category_ul")
																		.append(
																				"<li><a class='head' href='${pageContext.request.contextPath}/product?method=findByPage&pageNumber=1&cid="
																						+ this.cid
																						+ "'>"
																						+ this.cname
																						+ "</a></li>");
															})

										}, "json");

					})
</script>