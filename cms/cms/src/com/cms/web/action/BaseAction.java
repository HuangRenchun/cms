package com.cms.web.action;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.cms.bean.Category;
import com.cms.service.ICategoryService;
import com.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	private List<Category>categoryList;
	private static final long serialVersionUID = 1L;
    private ICategoryService categoryService=new CategoryServiceImpl();
	/*
     * 跳转到首页
     * */
    @Action(value="toIndex",results={
    		@Result(name="success",location="/WEB-INF/jsp/index.jsp")})
	public String toIndex(){
    	//调用service层方法查询所有栏目的信息，并将查到的数据赋给categoryList
    	categoryList=categoryService.list();
		return "success";
	}
    /*
     * 跳转到列表页面
     * */
    @Action(value="toList",results={
    		@Result(name="success",location="/WEB-INF/jsp/list.jsp")})
	public String toList(){
		return "success";
    }
    /*
     * 跳转到内容
     * */
    @Action(value="toContent",results={
    		@Result(name="success",location="/WEB-INF/jsp/content.jsp")})
	public String toContent(){
		return "success";
    }
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
}
