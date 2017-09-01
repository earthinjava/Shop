package com.duan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.duan.dao.UserDao;
import com.duan.domain.User;
import com.duan.utils.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void regist(User user) {
		Connection connection = JDBCUtil.getMySQLConn();
		String userName = user.getUserName();
		String uid = user.getUid();
		String telephone = user.getTelephone();
		int state = user.getState();
		String sex = user.getSex();
		String password = user.getPassword();
		String name = user.getName();
		String email = user.getEmail();
		String code = user.getCode();
		String birthday = user.getBirthday();

		String sql = "insert into user(uid,username,password,name,email,telephone,birthday,sex,state,code) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement presttm = null;
		try {
			presttm = connection.prepareStatement(sql);
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
		} finally {
			if (presttm != null) {
				try {
					presttm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public User active(String code) {
		Connection connection = JDBCUtil.getMySQLConn();
		String sql = "select * from user where code='" + code + "'";
		Statement sttm = null;
		try {
			sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			User user = creatUser(rs);
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (sttm != null) {
				try {
					sttm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	private User creatUser(ResultSet rs) {
		User user = null;
		try {
			while (rs.next()) {
				user = new User();
				String uid = rs.getString(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				String telephone = rs.getString(6);
				String birthday = rs.getString(7);
				String sex = rs.getString(8);
				int state = rs.getInt(9);
				String code = rs.getString(10);

				user.setUid(uid);
				user.setUserName(username);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
				user.setTelephone(telephone);
				user.setBirthday(birthday);
				user.setSex(sex);
				user.setState(state);
				user.setCode(code);

			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User loginByNameAndPassword(String username, String password) {
		Connection connection = JDBCUtil.getMySQLConn();
		String sql = "select * from user where username='" + username + "'";
		Statement sttm = null;
		try {
			sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			User user = creatUser(rs);
			if (user != null && user.getPassword().equals(password)) {
				return user;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (sttm != null) {
				try {
					sttm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	/**
	 * 传入用户，将数据库中的此用户更新
	 */
	@Override
	public void update(User user) {
		Connection connection = JDBCUtil.getMySQLConn();
		String userName = user.getUserName();
		String uid = user.getUid();
		String telephone = user.getTelephone();
		int state = user.getState();
		String sex = user.getSex();
		String password = user.getPassword();
		String name = user.getName();
		String email = user.getEmail();
		String code = user.getCode();
		String birthday = user.getBirthday();

		String sql = "update  user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? "
				+ "where uid='" + uid + "'";
		PreparedStatement presttm = null;
		try {
			presttm = connection.prepareStatement(sql);

			presttm.setString(1, userName);
			presttm.setString(2, password);
			presttm.setString(3, name);
			presttm.setString(4, email);
			presttm.setString(5, telephone);
			presttm.setString(6, birthday);
			presttm.setString(7, sex);
			presttm.setInt(8, state);
			presttm.setString(9, code);
			presttm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (presttm != null) {
				try {
					presttm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
