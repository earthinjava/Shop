<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/head.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/foot.css" />
<style>
.main {
	margin: 10px auto;
	width: 80%;
	height: 650px;
	text-align: center;
	overflow: hidden;
}	
</style>
<script type="text/javascript" src="/Shop/jsp/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<%@include file="/jsp/head.jsp"%>
	<div class="main">
		<c:if test="${hotproducts!=null }">
			<c:forEach items="${hotproducts }" var="p">
				<div
					style="text-align: center; float: left; margin: 10px 15px 10px 15px; width: 200px; height: 200px; overflow: hidden; background: #C0C0C0;">
					<ul style="text-align: center;">
						<li style="text-align: center;"><a
							href="/Shop/product?method=findproductbypid&pid=${p.pid }">${p.pname }</a>
						</li><br>
						<li>市场价：${p.market_price }</li>
						<li>商场价：${p.shop_price }</li>
					</ul>
				</div>
			</c:forEach>
		</c:if>
	</div>
	<%@include file="/jsp/foot.jsp"%>
</body>
</html>