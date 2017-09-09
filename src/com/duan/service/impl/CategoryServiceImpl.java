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
		// 1.调用dao层获得list结果集
		CategoryDao cd = new CategoryDaoImpl();
		List<Category> list = cd.findAll();
		// 2.将list转换为json字符串返回
		if (list != null && list.size() > 0) {
			return JsonUtil.list2json(list);
		}
		return null;
	}

	

}
