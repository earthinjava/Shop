package com.duan.dao;

import com.duan.domain.User;

public interface UserDao {

	void regist(User user);
	User active(String code);

}
