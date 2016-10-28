package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cms.bean.Category;
import com.cms.common.ConnectionFactory;

public class CategoryDao {
	//通过id来delete
	public void deleteById(long id){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				//2预处理sql
				String sql="delete  from cms where id=?";	
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				
				//3执行sql
				pstmt.executeUpdate();
				}finally{
				//4释放资源
					ConnectionFactory.close(null, pstmt, conn);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	public void save(Category category){
		/*
		 * 保存category的信息
		 * */
		
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				//2预处理sql
				String sql="insert into cms(name,code) values(?,?)";	
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,category.getName());
				pstmt.setInt(2, category.getCode());
				//3执行sql
				pstmt.executeUpdate();
				}finally{
				//4释放资源
					ConnectionFactory.close(null, pstmt, conn);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		}
	public List<Category> findAll(){
		List<Category>list=new ArrayList<Category>();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="select * from cms";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					long id=rs.getLong("id");
					String name=rs.getString("name");
					int code=rs.getInt("code");
					Category c=new Category(name,code);
					c.setId(id);
					list.add(c);
				}
				}finally{
				//4释放资源
					ConnectionFactory.close(rs, pstmt, conn);;	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	/*
	 * 
	 * 查询id
	 * */
	public Category findById(long id){
		Category category=null;
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="select * from cms where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					
					String name=rs.getString("name");
					int code=rs.getInt("code");
					category =new Category(name,code);
					category.setId(id);
					
				}
				}finally{
				//4释放资源
					ConnectionFactory.close(rs, pstmt, conn);;	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return category;

}
	
	
	public void update(Category category){
		/*
		 * 保存category的信息
		 * */
		
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				//2预处理sql
				String sql="update cms set name=?,code=? where id=?";	
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,category.getName());
				pstmt.setInt(2, category.getCode());
				pstmt.setLong(3, category.getId());
				//3执行sql
				pstmt.executeUpdate();
				}finally{
				//4释放资源
					ConnectionFactory.close(null, pstmt, conn);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		}
}
 