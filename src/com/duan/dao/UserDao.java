package com.duan.dao;

import com.duan.domain.User;

public interface UserDao {

	void regist(User user);
	User active(String code);
	User loginByNameAndPassword(String username, String password);
	void update(User user);

}
