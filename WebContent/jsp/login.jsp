<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/head.css" />
<script type="text/javascript" src="/Shop/jsp/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/foot.css" />
<title>登录页面</title>
</head>
<%@include file="/jsp/head.jsp"%>
<%
	String savename = "";
	Cookie[] cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("savename")) {
			savename = cookies[i].getValue();
		}
	}
%>
<body>
	<div style="height: 650px;">

		<div
			style="width: 300px; height: 180px; margin: 20px auto; background: green; text-align: left; padding: 15px auto;">
			<form action="<%=request.getContextPath()%>/user?method=login"
				method="post">

				<%
					if (session.getAttribute("msg") == null) {
				%>
				用户:<input type="text" name="username" id="username"
					value="<%=savename%>" style="width: 80px;"> <br> <br>密码:
				<input type="text" name="password" id="password"
					style="width: 80px;"><br> <br>
				<%
					} else if (session.getAttribute("msg") != null) {
				%>
				用户:<input type="text" name="username" id="username"
					value="<%=savename%>" style="width: 80px;"> <font color="red"><%=session.getAttribute("msg")%></font><br>
				<br> 密码:<input type="text" name="password" id="password"
					style="width: 80px;"><br> <br>
				<%
					}
				%>		
				
				<input type="submit" value="登录" /> <a
					href="<%=request.getContextPath()%>/user?method=registerUI">注册</a><br>
				<br> <input type="checkbox" name="savename" value="ok"
					checked="checked" />记住用户名<br>
			</form>
		</div>
	</div>
	<%@include file="/jsp/foot.jsp"%>
</body>
</html>