package com.duan.service.impl;

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
				+ "'>��ϲ" + user.getUserName() + "ע��ɹ�,��˼��</a>";
		MailsUtils.sendMail("18563715635@163.com", "gaoshu12nan", "smtp.163.com", user.getEmail(),
				"ע����֤��Ϣ", msg);

	}

	@Override
	public User active(String code) {
		User user=ud.active(code);		
		return user;
	}

}
