package com.cms.service;

import java.util.List;

import com.cms.bean.Category;

/*
 * 栏目页面逻辑业务
 * */

public interface ICategoryService {
	void add(Category category);
	List<Category> list();
	void delete(long id);
	Category findById(long id);
	void update(Category category);

}
