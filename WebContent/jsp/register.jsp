<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function form() {
		var username = document.getElementById("username").value;
		var pwd = document.getElementById("password").value;
		var email = document.getElementById("email").value;

		apos = email.indexOf("@")
		dotpos = email.lastIndexOf(".")

		if (username == null || username == "") {
			alert("用户名为空");
			document.getElementById("username").focus();
			return false;
		}
		if (pwd == null || pwd == "") {
			alert("密码为空");
			document.getElementById("password").focus();
			return false;
		}
		if (apos < 1 || dotpos - apos < 2) {
			alert("邮箱错误");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/user?method=regist"
		method="post" onsubmit="return form()">
		<input type="text" name="username" id="username">用户名 </input></br> 
		<input type="text" name="password" id="password">密码 </input></br> 
		<input type="text" name="name" id="name">姓名  </input></br>
		<input type="text" name="email" id="email" value="18563715635@163.com">邮箱 </input></br>
		<input type="text" name="telephone" id="telephone">电话 </input></br>
		<input type="text" name="birthday" id="birthday">生日  </input></br>
		<input type="radio" name="sex" value="男" checked>男</input></br>
		<input type="radio" name="sex" value="女">女</input></br> 
		<input type="submit" value="保存" />
	</form>
</body>
</html>