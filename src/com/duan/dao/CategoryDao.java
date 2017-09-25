package com.duan.dao;

import java.util.List;

import com.duan.domain.Category;

public interface CategoryDao {

	List<Category> findAll();

	void add(Category category);

	void del(String cid);

	void update(String cid);
	

}
