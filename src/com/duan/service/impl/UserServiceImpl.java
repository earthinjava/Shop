package com.duan.service.impl;

import com.duan.dao.UserDao;
import com.duan.dao.impl.UserDaoImpl;
import com.duan.domain.User;
import com.duan.service.UserService;
import com.duan.utils.MailsUtils;

public class UserServiceImpl implements UserService {
	@Override
	public void regist(User user) {
		// 调用dao完成注册
		UserDao ud = new UserDaoImpl();
		ud.regist(user);
		// 发送注册码		
		if (user.getEmail().contains("@")) {
			String msg="恭喜您注册成功";
			MailsUtils.sendMail("18563715635@163.com", "gaoshu12nan", "smtp.163.com",
					user.getEmail(), "注册验证", "这是一个注册验证");
		}
	}

}
