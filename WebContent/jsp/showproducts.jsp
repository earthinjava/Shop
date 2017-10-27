<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/foot.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/head.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分类</title>
<style>
.main {
	margin: 10px auto;
	width: 80%;
	height: 650px;
	text-align: center;
	overflow: hidden;
}

#active {
	background-color: #cc0000;
}
</style>
<script type="text/javascript" src="/Shop/jsp/jquery-3.2.1.min.js"></script>
</head>
<body>
	<%@include file="/jsp/head.jsp"%>
	<div class="main">
		<div style="height: 620px;">
			<c:forEach items="${pagebean.data }" var="p">
				<div
					style="text-align: center; float: left; margin: 10px 15px 0px 15px; width: 200px; height: 200px; overflow: hidden; background: #C0C0C0;">
					<ul style="text-align: center;">
						<li style="text-align: center;"><a
							href="/Shop/product?method=findproductbypid&pid=${p.pid }">${p.pname }</a>
						</li>
						<br>
						<li style="text-align: center;">商场价格：${p.market_price }</li>
						<br>
						<li style="text-align: center;">超市价格：${p.shop_price }</li>
						<br>
						<a href="/Shop/product?method=findproductbypid&pid=${p.pid }"><img
							src="${pageContext.request.contextPath }/image/${p.pimage }"
							width="100" height="100"></img></a>

					</ul>
				</div>
			</c:forEach>
		</div>
		<!-- 上一页 -->
		<div
			style="width: 80%; height: 30px; margin: 0 auto; text-align: center;">
			<ul
				style="text-align: center; width: 200px; height: 30px; margin: 0 auto;">
				<c:if test="${pagebean.pageNumber==1 }">
					<li style="display: inline;"><a
						href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=1&cid=${param.cid }
												">
							<span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:if test="${pagebean.pageNumber!=1 }">
					<li style="display: inline;"><a
						href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=${pagebean.pageNumber-1 }&cid=${param.cid }
												">
							<span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>

				<!-- 页码 -->
				<c:forEach begin="1" end="${pagebean.totalPage }" var="n">
					<c:if test="${pagebean.pageNumber==n }">
						<li style="display: inline;" class="active"><a
							href="javascript:void(0)">${n }</a></li>
					</c:if>
					<c:if test="${pagebean.pageNumber!=n }">
						<li style="display: inline;"><a
							href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=${n }&cid=${param.cid }">${n }</a></li>
					</c:if>
				</c:forEach>
				<!-- 下一页 -->
				<c:if test="${pagebean.pageNumber==pagebean.totalPage }">
					<li style="display: inline;"><a
						href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=${pagebean.pageNumber }&cid=${param.cid }
												">
							<span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<c:if test="${pagebean.pageNumber!=pagebean.totalPage }">
					<li style="display: inline;"><a
						href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=${pagebean.pageNumber+1 }&cid=${param.cid }
												">
							<span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<%@include file="/jsp/foot.jsp"%>
</body>
</html>