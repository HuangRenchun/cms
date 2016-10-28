package com.cms.service.impl;

import java.util.List;

import com.cms.bean.Article;
import com.cms.dao.ArticleDao;
import com.cms.service.IArticleService;

public class ArticleServiceImpl implements IArticleService{
     private ArticleDao articleDao=new ArticleDao();
	@Override
	public void add(Article article) {
		articleDao.save(article);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Article> list() {
		// TODO Auto-generated method stub
		return articleDao.findAll();
	}

	@Override
	public List<Article> listByCategory(long c_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article scanner(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
