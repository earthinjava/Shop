package com.duan.service.impl;

import com.duan.constant.Constant;
import com.duan.dao.UserDao;
import com.duan.dao.impl.UserDaoImpl;
import com.duan.domain.User;
import com.duan.service.UserService;
import com.duan.utils.MailsUtils;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	@Override
	public void regist(User user) {
		// ����dao���ע��		
		ud.regist(user);
		// ����ע����
		String msg = "<a href='http://localhost:8080/Shop/user?method=active&code=" + user.getCode()
				+ "'>欢迎" + user.getUserName() + "注册，请点击激活</a>";
		MailsUtils.sendMail("18563715635@163.com", "gaoshu12nan", "smtp.163.com", user.getEmail(),
				"注册激活", msg);

	}

	@Override
	public User active(String code) {
		//获得数据库user用户
		User user=ud.active(code);
		//若可获得用户则说明用户存在，则设置激活码为1，设置验证码为空
		if(user!=null){
			user.setCode(null);
			user.setState(Constant.USER_IS_ACTIVE);
			ud.update(user);
		}
		//若不存在说明用户错误返回null
		return user;
	}

	@Override
	public User login(String username, String password) {
		User user=ud.loginByNameAndPassword(username,password);		
		return user;
	}

}
