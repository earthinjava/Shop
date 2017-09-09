package com.duan.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.service.ProductService;
import com.duan.service.impl.ProductServiceImpl;

public class IndexServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//1.调用Service获得hot商品
		ProductService ps=new ProductServiceImpl();
		List<?> hotProducts=ps.findHotProducts();		
		//2.调用service获得最新商品
		//List newProducts=ps.findNewProducts();
		//3.将商品存储的域中
		request.setAttribute("hotproducts", hotProducts);
		//request.setAttribute("newproducts", newProducts);
		//4.跳转到主页
		return "/jsp/index.jsp";
	}
}
