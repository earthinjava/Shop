<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="right">
	<%
		if (session.getAttribute("username") == null) {
	%>
	<a href="<%=request.getContextPath()%>/user?method=loginUI">登录</a> <a
		href="<%=request.getContextPath()%>/user?method=registerUI">注册</a>
	<%
		} else if (session.getAttribute("username") != null) {
	%>
	<a href="<%=request.getContextPath()%>/user?method=showuser"><%=session.getAttribute("username")%>，您好</a>
	<a href="<%=request.getContextPath()%>/user?method=logout">退出</a>

	<%
		}
	%>
</div>
<div class="head">
	<ul></ul>
</div>
<script type="text/javascript">
	$(document).ready(
			function() {
				//发送AJAX请求，查询分类
				//发送请求url，发送请求参数，请求响应获得响应后执行回调函数
				$.post("${pageContext.request.contextPath}/category", {
					"method" : "findAll"
				}, function(result) {
					$(result).each(
							function() {
								$("ul").append(
										"<li><a href='${pageContext.request.contextPath}/product?method=findByPage&pageNumber=1&cid="
												+ this.cid + "'>" + this.cname
												+ "</a></li>");
							})

				}, "json");

			})
</script>