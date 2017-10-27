<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/foot.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/head.css" />
<style type="text/css">
.main {
	margin: 10px auto;
	width: 80%;
	height: 650px;
	text-align: center;
	overflow: hidden;
}
</style>

<script type="text/javascript">
	function msg() {
		//判断数量是否为空	
		
		alert("已提交至购物车");
	}
</script>
<script type="text/javascript" src="/Shop/jsp/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body>
	<%@include file="/jsp/head.jsp"%>
	<div class="main">
		<div class="product_image"
			style="text-align: center; float: left; margin: 10px 100px 10px 100px; width: 300px; height: 300px; overflow: hidden; background: #C0C0C0;">
			<img src="${pageContext.request.contextPath }/image/${product.pimage }" width="300" height="300"></img>					
		</div>
		<div
			style="margin: 10px auto; width: 300px; height: 300px; overflow: hidden; background:#F0F8FF;">
			<div style="margin: 10px;height:50px;">
				<ul style="text-align:left;height:50px;padding-left:0;">
					<li>商品名称：${product.pname }</li></br>
					<li>商品价格：${product.market_price }</li>
				</ul>
			</div>
			<div style="text-align:left;margin: 10px;">
				<form action="cart" method="get" onsubmit="return msg()">
					<input type="hidden" name="method" value="add2Cart" /> <input
						type="hidden" name="pid" value="${product.pid }" /> 数量： <input
						type="number" name="count" min="1" value="1" style="width:60px;"><br> <input type="submit"
						value="购买">
				</form>
			</div>
		</div>
	</div>
	<%@include file="/jsp/foot.jsp"%>
</body>
</html>