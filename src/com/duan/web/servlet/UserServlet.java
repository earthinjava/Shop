package com.duan.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.constant.Constant;
import com.duan.domain.User;
import com.duan.service.UserService;
import com.duan.service.impl.UserServiceImpl;
import com.duan.utils.UUIDutils;

public class UserServlet extends BaseServlet {
	//用户登录
	//用户注册
	//用户激活
	//用户退出
	private static final long serialVersionUID = 1L;
	/*
	 * 跳转到注册页面
	 */
	public String registerUI(HttpServletRequest req,HttpServletResponse resp){
		return "/jsp/register.jsp";
	}
	/*
	 * 跳转到登录页面
	 */
	public String loginUI(HttpServletRequest req,HttpServletResponse resp){
		return "/jsp/login.jsp";
	}
	
	/*
	 * 完成用户的注册操作
	 */	
	public String regist(HttpServletRequest req,HttpServletResponse resp){
		//获取数据
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String telephone=req.getParameter("telephone");
		String birthday=req.getParameter("birthday");
		String sex=req.getParameter("sex");		
		//封装数据
		User user=new User();
		user.setBirthday(birthday);		
		user.setUserName(userName);
		user.setPassword(password);;
		user.setName(name);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setSex(sex);
		user.setUid(UUIDutils.getID());
		user.setCode(UUIDutils.getID());
		user.setState(Constant.USER_IS_NOT_ACTIVE);
		//调用service处理数据
		UserService us=new UserServiceImpl();
		us.regist(user);
		
		
		
		return "/jsp/msg.jsp";
	}
	
	
}
