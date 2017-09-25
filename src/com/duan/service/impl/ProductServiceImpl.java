package com.duan.service.impl;

import java.util.List;

import com.duan.dao.ProductDao;
import com.duan.dao.impl.ProductDaoImpl;
import com.duan.domain.PageBean;
import com.duan.domain.Product;
import com.duan.service.ProductService;

public class ProductServiceImpl implements ProductService{

	
	@Override
	public List<?> findHotProducts() {
		//调用到层
		ProductDao pd=new ProductDaoImpl();
		List<?> products=pd.findHotProducts();
		return products;
	}

	public Product findProductByPid(String pid) {
		ProductDao pd=new ProductDaoImpl();
		return pd.findProductByPid(pid);
	}

	@Override
	public PageBean getPageBean(int pageNumber, int pagesize, String cid) {
		ProductDao pd=new ProductDaoImpl();
		PageBean pageBean=pd.getPageBean(pageNumber, pagesize,cid);
		return pageBean;
	}

}
