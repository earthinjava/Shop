<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/jsp/head.jsp"  %>
	<%
		if (session.getAttribute("username") == null) {
	%>
	<a href="<%=request.getContextPath()%>/user?method=loginUI">登录</a>
	<a href="<%=request.getContextPath()%>/user?method=registerUI">注册</a>
	<%
		} else if (session.getAttribute("username") != null) {
	%>
	<a href="<%=request.getContextPath()%>/user?method=showuser"><%=session.getAttribute("username") %>，您好</a>
	<a href="<%=request.getContextPath()%>/user?method=logout">exit</a>
	<%
		}
	%>	
</body>
</html>