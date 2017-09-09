<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
li {
	list-style: none;
}

#active {
	background-color: #cc0000;
}
</style>
</head>
<body>
	<ul>
		<c:forEach items="${pagebean.data }" var="p">
			<li><a href="/Shop/product?method=findproductbypid&pid=${p.pid }"
												>${p.pname }</a>
				</br></li>
			<br>
		</c:forEach>
	</ul>
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
		<ul style="text-align: center; margin-top: 10px;">
			<!-- 上一页 -->
			<c:if test="${pagebean.pageNumber==1 }">
				<li><a
					href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=1&cid=${param.cid }
												">
						<span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>
			<c:if test="${pagebean.pageNumber!=1 }">
				<li><a
					href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=${pagebean.pageNumber-1 }&cid=${param.cid }
												">
						<span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>
			
			<!-- 页码 -->
			<c:forEach begin="1" end="${pagebean.totalPage }" var="n">
				<c:if test="${pagebean.pageNumber==n }">
					<li class="active"><a href="javascript:void(0)">${n }</a></li>
				</c:if>
				<c:if test="${pagebean.pageNumber!=n }">
					<li ><a href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=${n }&cid=${param.cid }">${n }</a></li>
				</c:if>
			</c:forEach>


			<!-- 下一页 -->
			<c:if test="${pagebean.pageNumber==pagebean.totalPage }">
				<li><a
					href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=${pagebean.pageNumber }&cid=${param.cid }
												">
						<span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>
			<c:if test="${pagebean.pageNumber!=pagebean.totalPage }">
				<li><a
					href="${pageContext.request.contextPath}/product?method=findByPage&pageNumber=${pagebean.pageNumber+1 }&cid=${param.cid }
												">
						<span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>

			<li><a href="index.jsp">返回</a></li>
		</ul>
	</div>

</body>
</html>