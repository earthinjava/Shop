package com.duan.service;

import java.util.List;

import com.duan.domain.PageBean;
import com.duan.domain.Product;

public interface ProductService {

	List<?> findHotProducts();
	Product findProductByPid(String pid);
	PageBean getPageBean(int pageNumber, int pagesize, String cid);


}
