package com.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cms.bean.Article;
import com.cms.common.ConnectionFactory;

public class ArticleDao {
	public void save(Article article){
		/*
		 * 保存文章
		 * */
		
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				//2预处理sql
				String sql="insert into t_article(title,content,auther,publisurDate,clickTimes,c_id) "
						+ "values(?,?,?,?,?,?)";	
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,article.getTitle());
				pstmt.setString(2, article.getContent());
				pstmt.setString(3,article.getAuther() );
				pstmt.setDate(4, new Date( article.getPublisurDate().getTime()));
				pstmt.setInt(5, article.getClickTimes());
				pstmt.setLong(6,article.getC_id());
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
	public List<Article> findAll(){
		List<Article>list=new ArrayList<Article>();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="select * from t_article";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					long id=rs.getLong("id");
					String title=rs.getString("title");
					String auther=rs.getString("auther");
					String content=rs.getString("content");
					Date date=rs.getDate("publisurDate");
					int clickTimes=rs.getInt("clickTimes");
					long c_id=rs.getLong("c_id");
					
					Article article=new Article();
					article.setAuther(auther);
					article.setC_id(c_id);
					article.setClickTimes(clickTimes);
					article.setContent(content);
					article.setId(id);
					article.setPublisurDate(date);
					article.setTitle(title);
					
					 
				    list.add(article);
					
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
}
