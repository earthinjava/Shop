package com.duan.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.domain.PageBean;
import com.duan.domain.Product;
import com.duan.service.ProductService;
import com.duan.service.impl.ProductServiceImpl;

public class ProductServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String findproductbypid(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//1.获得pid
		String pid=request.getParameter("pid");
		//2.调用service取得产品
		Product p=new ProductServiceImpl().findProductByPid(pid);
		//3.保存到request中
		request.setAttribute("product", p);
		//4.跳转到商品显示页面
		return "/jsp/showproduct.jsp";
	}
	public String findByPage(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//1.获得cid 获得页码
		int pageNumber=1;
		pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		int pagesize=3;
		String cid=request.getParameter("cid");
		//2.调用service取得pagebean
		ProductService ps=new ProductServiceImpl();		
		PageBean pageBean=ps.getPageBean(pageNumber,pagesize,cid);
		//3.保存到request中
		request.setAttribute("pagebean", pageBean);
		//4.跳转到商品显示页面
		return "/jsp/showproducts.jsp";
	}
}
