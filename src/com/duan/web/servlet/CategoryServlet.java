package com.duan.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.service.CategoryService;
import com.duan.service.impl.CategoryServiceImpl;

public class CategoryServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 0.设置响应编码
			resp.setContentType("text/html;charset=utf-8");			
			// 1.获取数据
			CategoryService cs = new CategoryServiceImpl();
			String values = cs.findAll();			
			// 2.将数据写回到head.jsp
			
			resp.getWriter().println(values);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
