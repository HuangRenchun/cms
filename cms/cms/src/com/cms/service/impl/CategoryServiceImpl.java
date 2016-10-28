package com.cms.service.impl;

import java.util.List;

import com.cms.bean.Category;
import com.cms.dao.CategoryDao;
import com.cms.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
    private CategoryDao categoryDao=new CategoryDao();
	@Override
	public void add(Category category) {
		categoryDao.save(category);
		
	}
	@Override
	public List<Category> list() {
		
		return categoryDao.findAll();
	}
	@Override
	public void delete(long id) {
		categoryDao.deleteById(id);
		
		
	}
	
	public Category findById(long id) {
		
		return categoryDao.findById(id);
	}
	@Override
	public void update(Category category) {
		
		 categoryDao.update(category);
	}

}
