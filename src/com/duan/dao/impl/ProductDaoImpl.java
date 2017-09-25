package com.duan.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.duan.constant.Constant;
import com.duan.dao.ProductDao;
import com.duan.domain.Category;
import com.duan.domain.PageBean;
import com.duan.domain.Product;
import com.duan.utils.JDBCUtil;


public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findHotProducts() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = null;
		String sql = "select * from product where is_hot=1 limit "+Constant.HOT_PRODUCT_NUMBER;
		Statement sttm = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			sttm = conn.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				String pid = rs.getString(1);
				String pname = rs.getString(2);
				double market_price = rs.getDouble(3);
				double shop_price = rs.getDouble(4);
				String pimage = rs.getString(5);
				Date pdate = rs.getDate(6);
				int is_hot = rs.getInt(7);
				String pdesc = rs.getString(8);
				int pflag = rs.getInt(9);
				Category category = new CategoryDaoImpl().getCategory(rs.getString(10));

				Product product = new Product();
				product.setPid(pid);
				product.setPname(pname);
				product.setMarket_price(market_price);
				product.setShop_price(shop_price);
				product.setPimage(pimage);
				product.setPdate(pdate);
				product.setCategory(category);
				product.setIs_hot(is_hot);
				product.setPdesc(pdesc);
				product.setPflag(pflag);

				products.add(product);

			}
			return products;

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

	@Override
	public Product findProductByPid(String pid) {
		Connection conn = null;
		String sql = "select * from product where pid=" + pid;
		Statement sttm = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			sttm = conn.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			Product product = new Product();
			while (rs.next()) {

				String pname = rs.getString(2);
				double market_price = rs.getDouble(3);
				double shop_price = rs.getDouble(4);
				String pimage = rs.getString(5);
				Date pdate = rs.getDate(6);
				int is_hot = rs.getInt(7);
				String pdesc = rs.getString(8);
				int pflag = rs.getInt(9);
				Category category = new CategoryDaoImpl().getCategory(rs.getString(10));

				product.setPid(pid);
				product.setPname(pname);
				product.setMarket_price(market_price);
				product.setShop_price(shop_price);
				product.setPimage(pimage);
				product.setPdate(pdate);
				product.setCategory(category);
				product.setIs_hot(is_hot);
				product.setPdesc(pdesc);
				product.setPflag(pflag);

			}
			return product;

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

	// 根据当前页码，分类号码，每页数量获得一个pagebean
	@Override
	public PageBean getPageBean(int pageNumber, int pagesize, String cid) {		
		Connection conn = null;
		
		PageBean pageBean=new PageBean();
		pageBean.setData(new ArrayList<>());
		pageBean.setPageNumber(pageNumber);
		pageBean.setPageSize(pagesize);
		int totalRecord=new ProductDaoImpl().getTotalRecod(cid);
		pageBean.setTotalRecord(totalRecord);
		
		int totalPage=totalRecord%pagesize==0?totalRecord/pagesize:totalRecord/pagesize+1;
		pageBean.setTotalPage(totalPage);
		
		int end=pagesize;
		int begin=pagesize*pageNumber-pagesize;
		
		
		String sql = "select * from product where cid="+cid+" limit "+begin+","+end;
		Statement sttm = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			sttm = conn.createStatement();				
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				String pid = rs.getString(1);
				String pname = rs.getString(2);
				double market_price = rs.getDouble(3);
				double shop_price = rs.getDouble(4);
				String pimage = rs.getString(5);
				Date pdate = rs.getDate(6);
				int is_hot = rs.getInt(7);
				String pdesc = rs.getString(8);
				int pflag = rs.getInt(9);
				Category category = new CategoryDaoImpl().getCategory(rs.getString(10));

				Product product = new Product();
				product.setPid(pid);
				product.setPname(pname);
				product.setMarket_price(market_price);
				product.setShop_price(shop_price);
				product.setPimage(pimage);
				product.setPdate(pdate);
				product.setCategory(category);
				product.setIs_hot(is_hot);
				product.setPdesc(pdesc);
				product.setPflag(pflag);

				pageBean.getData().add(product);				

			}
			return pageBean;

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

	private int getTotalRecod(String cid) {
		
		Connection conn = null;		
		String sql = "select * from product where cid="+cid;		
		Statement sttm = null;
		int count=0;
		try {
			conn = JDBCUtil.getMySQLConn();
			sttm = conn.createStatement();				
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				count++;
			}
			return count;

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
		return count;		
	}

}
