package com.duan.service;

import java.util.List;

import com.duan.domain.Category;

public interface CategoryService {

	String findAll();

	List<Category> findlist();

	void add(Category category);

	void del(String cid);

	void upate(String cid);
	

}
