<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<ul>		
	</ul>
	<script type="text/javascript">
		$(function(){
			//发送AJAX请求，查询分类
			//发送请求url，发送请求参数，请求响应获得响应后执行回调函数
			$.post("${pageContext.request.contextPath}/category",{"method":"findAll"},function(result){				
			$(result).each(function(){
				$("ul").append("<li><a href='#'>"+this.cname+"</a></li>");
			})	
				
			},"json");
		})
	
	</script>
</div>