<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<%
	String savename = "";
	Cookie[] cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {
		if(cookies[i].getName().equals("savename")){
			savename=cookies[i].getValue();			
		}
	}
%>
<body>
	<form action="<%=request.getContextPath()%>/user?method=login"
		method="post">

		<%
			if (session.getAttribute("msg") == null) {
		%>
		<input type="text" name="username" id="username" value=<%=savename%>>用户名
		</input></br> <input type="text" name="password" id="password">密码 </input></br>
		<%
			} else if (session.getAttribute("msg") != null) {
		%>
		<input type="text" name="username" id="username" value=<%=savename%>>用户名 </input>
		<font color="red"><%=session.getAttribute("msg")%></font></br> 
		<input type="text" name="password" id="password">密码 </input></br>
		<%
			}
		%>
		<input type="submit" value="登录" /> <input type="checkbox"
			name="savename" value="ok" checked="checked"/>记住用户名</br> <a
			href="<%=request.getContextPath()%>/user?method=registerUI">注册</a>
	</form>
</body>
</html>