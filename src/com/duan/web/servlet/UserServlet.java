package com.duan.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.constant.Constant;
import com.duan.domain.User;
import com.duan.service.UserService;
import com.duan.service.impl.UserServiceImpl;
import com.duan.utils.UUIDutils;

public class UserServlet extends BaseServlet {
	//�û���¼
	//�û�ע��
	//�û�����
	//�û��˳�
	private static final long serialVersionUID = 1L;
	/*
	 * ��ת��ע��ҳ��
	 */
	public String registerUI(HttpServletRequest req,HttpServletResponse resp){
		return "/jsp/register.jsp";
	}
	/*
	 * ��ת����¼ҳ��
	 */
	public String loginUI(HttpServletRequest req,HttpServletResponse resp){
		return "/jsp/login.jsp";
	}
	
	/*
	 * ����û���ע�����
	 */	
	public String regist(HttpServletRequest req,HttpServletResponse resp){
		//��ȡ����
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String telephone=req.getParameter("telephone");
		String birthday=req.getParameter("birthday");
		String sex=req.getParameter("sex");		
		//��װ����
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
		//����service��������
		UserService us=new UserServiceImpl();
		us.regist(user);
		
		
		
		return "/jsp/msg.jsp";
	}
	
	
}
