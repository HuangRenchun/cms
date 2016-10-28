package com.cms.web.action.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.cms.bean.Category;
import com.cms.service.ICategoryService;
import com.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	//同名参数传值
    private Long id;
	private String name;
	private Integer code;
	private List<Category>categoryList;
	private Category category;
	
	private ICategoryService categoryService=new CategoryServiceImpl();
	private static final long serialVersionUID = 1L;
	/*
	 * 跳转到
	 * 添加栏目管理
	 * 
	 * */
	
	@Action(value="toAddCategory",results={@Result(name="success",location="/WEB-INF/jsp/manager/addCategory.jsp")})
    public String toAddCategory(){
    	return "success";
    	/*
    	 * 跳转到栏目管理
    	 * */
    }
	@Action(value="toCategoryManager",results={@Result(name="success",location="/WEB-INF/jsp/manager/categoryManager.jsp")})
    public String toCategoryManager(){
		//调用service层的方法
		categoryList=categoryService.list();
    	return "success";
    	
    }
	/*
	 *跳转到修改页面
	 * 
	 * */
	@Action(value="toUpdCategory",results=
		{@Result(name="success",location="/WEB-INF/jsp/manager/updCategory.jsp")})
    public String toUpdCategory(){
		//调用service层的方法
		category=categoryService.findById(id);
    	return "success";
	}
	/*
	 * 
	 * 跳转到添加栏目
	 * 
	 * */
	@Action(value="addCategory")
    public void addCategory(){
		Category category=new Category(name,code);
		categoryService.add(category);
		//System.out.println(name+"--"+""+code);
    	
    }
	@Action(value="delCategory")
    public void delCategory(){
		//System.out.println("id="+id);
		categoryService.delete(id);
    	
    }
	/*
	 * 更新数据
	 * */
	@Action(value="updCategory")
    public void updCategory(){
			Category category=new Category(name,code);
			category.setId(id);
			categoryService.update(category);
			//System.out.println(name+"--"+""+code);
	    	
	    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}

