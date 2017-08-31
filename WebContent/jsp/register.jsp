<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

function form(){
	document.getElementByID("").
}



</script>




</head>
<body>
<form action="<%=request.getContextPath() %>/user?method=regist" method="post" onsubmit="return form()" >
	<input type="text" name="username">注册名
	<input type="text" name="password">密码
	<input type="text" name="name">姓名
	<input type="text" name="email">邮箱
	<input type="text" name="telephone">电话
	<input type="text" name="birthday">生日
	<input type="radio" name="sex" value="男" checked>男
	<input type="radio" name="sex" value="女">女
	<input type="submit" value="保存"/>
</form>
</body>
</html>