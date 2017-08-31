package com.duan.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//获取方法名称呢个
			String mName = req.getParameter("method");
			//判断方法是否为空，若为空设定为默认方法
			if(mName==null||mName.trim().length()==0){
				mName="index";
			}			
			//获得方法
			Method m = this.getClass().getMethod(mName, HttpServletRequest.class, HttpServletResponse.class);
			//执行方法
			String path=(String) m.invoke(this, req, resp);
			//判断路径执行跳转
			if(path!=null&&path.trim().length()!=0){
				req.getRequestDispatcher(path).forward(req, resp);
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {			
			e.printStackTrace();
		}

	}
	//默认的方法
	public String index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().println("method is null");
		return null;
	}

}
