package com.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cms.bean.Medicine;
import com.cms.common.ConnectionFactory;

public class MedicineDao {
	public void save(Medicine medicine){
		/*
		 * 保存的信息
		 * */
		
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				//2预处理sql
				String sql="insert into t_medicine(operator,storageTime,name,manufacturer,effectiveDate,salePrice,"
						+ "purchasePrice,number,code,indication) "
						+ "values(?,?,?,?,?,?,?,?,?,?)";
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,medicine.getOperator());
       			pstmt.setDate(2, new Date(medicine.getStorageTime().getTime()));
       			pstmt.setString(3,medicine.getName() );
       			pstmt.setString(4, medicine.getManufacturer());
       			pstmt.setString(5, medicine.getEffectiveDate());
       			pstmt.setFloat(6,medicine.getSalePrice() );
       			pstmt.setFloat(7, medicine.getPurchasePrice());
       			pstmt.setString(8, medicine.getNumber());
       			pstmt.setInt(9, medicine.getCode());
       			pstmt.setString(10, medicine.getIndication());
       			
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
	public List<Medicine> findAll(){
		List<Medicine>list=new ArrayList<Medicine>();
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="select * from t_medicine";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					long id=rs.getLong("id");
					String operator=rs.getString("operator");
					Date storageTime=rs.getDate("storageTime");
					String name=rs.getString("name");
					String manufacturer=rs.getString("manufacturer");
					String effectiveDate=rs.getString("effectiveDate");
					float salePrice=rs.getFloat("salePrice");
					float purchasePrice=rs.getFloat("purchasePrice");
					String number=rs.getString("number");
					int code=rs.getInt("code");
					String indication=rs.getString("indication");
					Medicine c=new Medicine(operator,storageTime,name,manufacturer,effectiveDate,salePrice,purchasePrice,number,code,indication);
					c.setId(id);
					list.add(c);
				}
				}finally{
				//4释放资源
					ConnectionFactory.close(rs, pstmt, conn);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	public void deleteById(long id){
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				//2预处理sql
				String sql="delete  from t_medicine where id=?";	
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
	public Medicine findById(long id){
		Medicine medicine=null;
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				String sql="select * from t_medicine where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					//long id=rs.getLong("id");
					String operator=rs.getString("operator");
					Date storageTime=rs.getDate("storageTime");
					String name=rs.getString("name");
					String manufacturer=rs.getString("manufacturer");
					String effectiveDate=rs.getString("effectiveDate");
					float salePrice=rs.getFloat("salePrice");
					float purchasePrice=rs.getFloat("purchasePrice");
					String number=rs.getString("number");
					int code=rs.getInt("code");
					String indication=rs.getString("indication");
					medicine =new Medicine(operator,storageTime,name,manufacturer,effectiveDate,salePrice,purchasePrice,number,code,indication);
					medicine.setId(id);
					
				}
				}finally{
				//4释放资源
					ConnectionFactory.close(rs, pstmt, conn);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return medicine;
	}
	public void update(Medicine medicine){
		System.out.println("sql="+medicine.getId());
		try{
			Connection conn=null;
			PreparedStatement pstmt=null;
			try{
				//1注册驱动，获取连接
				conn=ConnectionFactory.getConn();
				//2预处理sql
				String sql="update t_medicine set operator=?,storageTime=?,name=?,manufacturer=?,effectiveDate=?,salePrice=?,"
						+ "purchasePrice=?,number=?,code=?,indication=? where id=?";	
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,medicine.getOperator());
       			pstmt.setDate(2, new Date(medicine.getStorageTime().getTime()));
       			pstmt.setString(3,medicine.getName() );
       			pstmt.setString(4, medicine.getManufacturer());
       			pstmt.setString(5, medicine.getEffectiveDate());
       			pstmt.setFloat(6,medicine.getSalePrice() );
       			pstmt.setFloat(7, medicine.getPurchasePrice());
       			pstmt.setString(8, medicine.getNumber());
       			pstmt.setInt(9, medicine.getCode());
       			pstmt.setString(10, medicine.getIndication());
       			pstmt.setLong(11, medicine.getId());
				
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
	


