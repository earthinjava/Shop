<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.head {
	list-style-type: none;
	margin: 10;
	padding: 10;
	overflow: hidden;
}

li {
	list-style: none;
	float: left;
}

a:link, a:visited {
	display: block;
	width: 120px;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #bebebe;
	text-align: center;
	padding: 4px;
	text-decoration: none;
	text-transform: uppercase;
}

a:hover, a:active {
	background-color: #cc0000;
}

.right {
	float: right;
}

.product {
	background-color: #cc0000;
	margin: 20;
	padding: 20;
	overflow: hidden;
}
</style>
<script type="text/javascript" src="/Shop/jsp/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<%@include file="/jsp/head.jsp"%>	
	<div class="product">
		<c:if test="${hotproducts!=null }">
			<c:forEach items="${hotproducts }" var="p">
				<a href="/Shop/product?method=findproductbypid&pid=${p.pid }"
												>${p.pname }</a>
				</br>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>