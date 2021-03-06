package com.duan.dao;

import java.util.List;

import com.duan.domain.PageBean;
import com.duan.domain.Product;

public interface ProductDao {

	List<?> findHotProducts();

	Product findProductByPid(String pid);

	PageBean getPageBean(int pageNumber, int pagesize, String cid);

	List<Product> findAll();

	void save(Product product);

}
