package com.duan.service;

import com.duan.domain.User;

public interface UserService {

	void regist(User user);
	User active(String code);
	User login(String username, String password);
	User getUserByUserName(String userName);
}
