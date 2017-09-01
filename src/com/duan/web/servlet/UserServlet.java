package com.duan.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.constant.Constant;
import com.duan.domain.User;
import com.duan.service.UserService;
import com.duan.service.impl.UserServiceImpl;
import com.duan.utils.UUIDutils;

public class UserServlet extends BaseServlet {
	// 用户登录
	// 用户注册
	// 用户激活
	// 用户退出
	private static final long serialVersionUID = 1L;

	/*
	 * 跳转到注册页面
	 */
	public String registerUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/register.jsp";
	}

	/*
	 * 跳转到登录页面
	 */
	public String loginUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/login.jsp";
	}

	/*
	 * 完成用户的注册操作
	 */
	public String regist(HttpServletRequest req, HttpServletResponse resp) {
		// 获取数据
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		String birthday = req.getParameter("birthday");
		String sex = req.getParameter("sex");
		// 封装数据
		User user = new User();
		user.setBirthday(birthday);
		user.setUserName(userName);
		user.setPassword(password);
		;
		user.setName(name);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setSex(sex);
		user.setUid(UUIDutils.getID());
		user.setCode(UUIDutils.getID());
		user.setState(Constant.USER_IS_NOT_ACTIVE);
		// 调用service处理数据
		UserService us = new UserServiceImpl();
		us.regist(user);
		return "/jsp/msg.jsp?msg=注册成功，请前往邮箱激活";
	}

	/*
	 * 完成用户的激活
	 */
	public String active(HttpServletRequest req, HttpServletResponse resp) {
		// 获取数据
		String code = req.getParameter("code");
		// 调用service处理数据
		UserService us = new UserServiceImpl();
		User u = us.active(code);
		if (u != null) {
			return "/jsp/msg.jsp?msg=验证成功";
		} else {
			return "/jsp/msg.jsp?msg=验证错误";
		}
	}

	//
	public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 获取数据
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 调用service处理数据
		UserService us = new UserServiceImpl();
		User u = us.login(username, password);
		// 若登录正确，存储用户名并回到主页
		if (u == null) {
			req.getSession().setAttribute("msg", "用户名或密码错误");
			return "/jsp/login.jsp";
		}
		// 若登录错误返回登录页面
		if (u.getState() == Constant.USER_IS_NOT_ACTIVE) {
			req.getSession().setAttribute("msg", "请先验证邮箱再登录");
			return "/jsp/login.jsp";
		} else {
			/*
			 * 若勾选了保存用户名，则保存到cookie中,cookie没有修改操作，只需要创建同名的cookie覆盖即可
			 */
			if (req.getParameter("savename")!=null) {
				if (req.getParameter("savename").equals("ok")) {
					Cookie cookie = new Cookie("savename", URLEncoder.encode(username, "utf-8"));
					cookie.setMaxAge(604800);
					cookie.setPath(req.getContextPath() + "/");
					resp.addCookie(cookie);
				}
			}

			req.getSession().setAttribute("username", username);
			resp.sendRedirect(req.getContextPath());
			return null;
		}

	}

	//
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		// 清空session
		req.getSession().invalidate();
		return "/jsp/index.jsp";

	}
}
