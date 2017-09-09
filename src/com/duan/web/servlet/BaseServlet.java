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
			//��ȡ���������ظ�
			String mName = req.getParameter("method");				
			//�жϷ����Ƿ�Ϊ�գ���Ϊ���趨ΪĬ�Ϸ���
			if(mName==null||mName.trim().length()==0){
				mName="index";
			}
			System.out.println(mName);
			//��÷���
			Method m = this.getClass().getMethod(mName, HttpServletRequest.class, HttpServletResponse.class);
			//ִ�з���
			String path=(String) m.invoke(this, req, resp);		
			
			if(path!=null&&path.trim().length()!=0){
				req.getRequestDispatcher(path).forward(req, resp);
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {			
			e.printStackTrace();
		}

	}
	//Ĭ�ϵķ���
	public String index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().println("method is null");
		return null;
	}

}
