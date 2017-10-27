package com.duan.service.impl;

import java.util.List;

import com.duan.dao.CategoryDao;
import com.duan.dao.impl.CategoryDaoImpl;
import com.duan.domain.Category;
import com.duan.service.CategoryService;
import com.duan.utils.JsonUtil;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public String findAll() {			
		List<Category> list = findlist();
		// 2.将list转换为json字符串返回
		if (list != null && list.size() > 0) {
			return JsonUtil.list2json(list);
		}
		return null;
	}
	@Override
	public List<Category> findlist() {		
		CategoryDao cd = new CategoryDaoImpl();		
		return cd.findAll();
	}
	@Override
	public void add(Category category) {
		CategoryDao cd=new CategoryDaoImpl();
		cd.add(category);
		
	}
	@Override
	public void del(String cid) {
		CategoryDao cd=new CategoryDaoImpl();
		cd.del(cid);
		
	}
	@Override
	public void upate(String cid) {
		CategoryDao cd=new CategoryDaoImpl();
		cd.update(cid);
	}
	public Category getCategoryById(String value) {
		return new CategoryDaoImpl().getCategory(value);		
	}

	

}
