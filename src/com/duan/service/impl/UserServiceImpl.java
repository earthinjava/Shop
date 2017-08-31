package com.duan.service.impl;

import com.duan.dao.UserDao;
import com.duan.dao.impl.UserDaoImpl;
import com.duan.domain.User;
import com.duan.service.UserService;
import com.duan.utils.MailsUtils;

public class UserServiceImpl implements UserService {
	@Override
	public void regist(User user) {
		// ����dao���ע��
		UserDao ud = new UserDaoImpl();
		ud.regist(user);
		// ����ע����		
		if (user.getEmail().contains("@")) {
			String msg="��ϲ��ע��ɹ�";
			MailsUtils.sendMail("18563715635@163.com", "gaoshu12nan", "smtp.163.com",
					user.getEmail(), "ע����֤", "����һ��ע����֤");
		}
	}

}
