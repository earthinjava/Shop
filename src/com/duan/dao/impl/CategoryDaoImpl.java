package com.duan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.duan.dao.CategoryDao;
import com.duan.domain.Category;
import com.duan.utils.JDBCUtil;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAll() {
		Connection conn = JDBCUtil.getMySQLConn();
		String sql = "select * from category";
		Statement sttm = null;
		try {
			sttm = conn.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			List<Category> categorys = creatCategoryList(rs);
			return categorys;

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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public Category getCategory(String cid) {
		Connection conn = null;
		String sql = "select * from category where cid=" + cid;
		Statement sttm = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			sttm = conn.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			List<Category> categorys = creatCategoryList(rs);
			return categorys.get(0);

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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private List<Category> creatCategoryList(ResultSet rs) {
		List<Category> categories = new ArrayList<Category>();
		try {
			while (rs.next()) {
				String cid = rs.getString(1);
				String cname = rs.getString(2);
				Category category = new Category();
				category.setCid(cid);
				category.setCname(cname);
				categories.add(category);
			}
			return categories;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void add(Category category) {
		
		Connection conn = null;
		String sql = "insert into category values(?,?)";
		PreparedStatement sttm = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			sttm = conn.prepareStatement(sql);
			sttm.setString(1, category.getCid());
			sttm.setString(2, category.getCname());
			
			sttm.executeUpdate();
		

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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public void del(String cid) {
		Connection conn = null;
		String sql = "delete from category where cid=?";
		PreparedStatement sttm = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			sttm = conn.prepareStatement(sql);
			sttm.setString(1, cid);			
			sttm.executeUpdate();
		

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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public void update(String cid) {	
		
	}

	
}
