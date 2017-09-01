<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("username") == null) {
	%>
	<a href="<%=request.getContextPath()%>/user?method=loginUI">登录</a>
	<a href="<%=request.getContextPath()%>/user?method=registerUI">注册</a>
	<%
		} else if (session.getAttribute("username") != null) {
	%>
	<a href="<%=request.getContextPath()%>/user?method=showuser"><%=session.getAttribute("username") %>，您好</a>
	<a href="<%=request.getContextPath()%>/user?method=logout">退出</a>
	<%
		}
	%>
</body>
</html>