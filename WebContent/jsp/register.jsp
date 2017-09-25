<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/foot.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/head.css" />
<script type="text/javascript" src="/Shop/jsp/jquery-3.2.1.min.js"></script>
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
	<%@include file="/jsp/head.jsp"%>
	<div style="height: 650px;">
		<div
			style="background: green; width: 255px; height: 300px; margin: 150px auto; text-align: left;">
			<form style="margin: 10px auto;"
				action="<%=request.getContextPath()%>/user?method=regist"
				method="post" onsubmit="return form()">
				用户:<input type="text" name="username" id="username"><br>
				<br> 密码:<input type="text" name="password" id="password"><br>
				<br> 姓名:<input type="text" name="name" id="name"><br>
				<br> 邮箱:<input type="text" name="email" id="email"
					value="18563715635@163.com"> <br>
				<br> 电话:<input type="text" name="telephone" id="telephone"><br>
				<br> 生日:<input type="text" name="birthday" id="birthday"><br>
				<br> 性别： <input type="radio" name="sex" value="男" checked>男
				<input type="radio" name="sex" value="女">女<br>
				<br> <input type="submit" value="保存" />
			</form>
		</div>
	</div>
	<%@include file="/jsp/foot.jsp"%>
</body>
</html>