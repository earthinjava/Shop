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
<title>我的订单</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/jsp/head.jsp"%>
	<div class="main">
		<strong>${msg }</strong>
	</div>	
	<%@include file="/jsp/foot.jsp"%> 
   
</body>
</html>