package com.duan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.duan.dao.UserDao;
import com.duan.domain.User;
import com.duan.utils.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void regist(User user) {
		Connection connection=JDBCUtil.getMySQLConn();
		String userName=user.getUserName();
		String uid=user.getUid();
		String telephone=user.getTelephone();
		int state=user.getState();
		String sex=user.getSex();
		String password=user.getPassword();
		String name=user.getName();
		String email=user.getEmail();
		String code=user.getCode();
		String birthday=user.getBirthday();	
		
		String sql="insert into user(uid,username,password,name,email,telephone,birthday,sex,state,code) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement presttm=connection.prepareStatement(sql);
			presttm.setString(1, uid);
			presttm.setString(2, userName);
			presttm.setString(3, password);
			presttm.setString(4, name);
			presttm.setString(5, email);
			presttm.setString(6, telephone);
			presttm.setString(7, birthday);
			presttm.setString(8, sex);
			presttm.setInt(9, state);
			presttm.setString(10, code);
			presttm.executeUpdate();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
	}

}
