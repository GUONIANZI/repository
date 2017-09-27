package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import entity.Department;
import entity.Project;

public class ProjectDao extends BaseDao{


	public List<Project> searchAll() {
		List<Project> list = new ArrayList<Project>();
		try {
			
			// 5 执行sql语句
            getStatement();
			ResultSet rs = stat.executeQuery("select * from project");
			// 6 处理结果
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				list.add(pro);
			}
			

		

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}
	
	//查询id
	public Project searchById(int Id) {
		Project pro = new Project();
		try {
			
			// 5 执行sql语句
            getStatement();
			ResultSet rs = stat.executeQuery("select * from project where id="+Id);
			// 6 处理结果
			while (rs.next()) {
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
			
				
			}
			

		

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return pro;
	}


	
	//增加----------------------------------------------
	public boolean add(Project pro) {
		boolean flag=false;
		try {

			// 4 建立sql执行器
            getStatement();

			// 5 执行sql语句
			String sql = "insert into project (name) values('" + pro.getName() +  "')";
			int result = stat.executeUpdate(sql);
			// 6 处理结果
			if(result>0){
				flag=true;
				}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return flag;
	}

	
	//修改----------------------------------------------------
	
	public boolean update(Project pro) {
		  boolean flag=true;
			try {

				
				String sql="update project set name=? where id=?";
				         getPreparedStatement(sql);
						 pstat.setString(1,pro.getName());
						 pstat.setInt(2,pro.getId());

//				int id=bj.getId();		 
//				String sql="update project set name='" +bj.getName()+ "', sex='"+bj.getSex()+"',age ='"+bj.getAge()+"' where id="+id;
//				ResultSet rs= stat.executeQuery(sql);//只有查询的时候调executeQuery
				int result= pstat.executeUpdate
						
						();//增删改的时候统一调executeUpdate，且是int类型的，表明的是影响的行数
				
				//6，处理结果集
				if(result>0){
			    flag=true;
				}

				
			}  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
			return flag;
	}
	
  
	//刪除------------------------------------------------------------
	public int delete(Project pro) {
		//删除就定义成boolean类型的，便于以后自己拿出来同上面的比较
      int result =0;
		try {
			//4，建立sql执行器
            getStatement();

			//5，执行sql语言
			int id=pro.getId();
			String sql="delete from project where id="+id;
//			ResultSet rs= stat.executeQuery(sql);//只有查询的时候调executeQuery
			result= stat.executeUpdate(sql);//增删改的时候统一调executeUpdate，且是int类型的，表明的是影响的行数
	

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}

		return result;
	}

	
	//查询-------------------------------------------------------
	public List<Project> searchByCondition(Project condition) {
		List<Project> list = new ArrayList<Project>();
		
		  getStatement();
		  
//			String where = "";
//			
//			if (!condition.getName().equals("")) {
//
//				where +=  " and name  '" + condition.getName() + "'";
//				
//			}
//			if (!condition.getSex().equals("")) {
//				where +=  "and  sex='" + condition.getSex() + "'";
//				
//			}
//			if (condition.getAge() != -1) {
//				where +=  " and  age=" + condition.getAge();
//			}
//
//			String sql = "select * from project 1=1 " + where;
		  String where = "";
			String str = " where ";
			if (!condition.getName().equals("")) {

				where += str + "  name like '" + condition.getName() + "'";
				str = " and ";
			}


			String sql = "select * from project  " + where;

		  System.out.println(sql);
		  
			 try {
				rs = stat.executeQuery(sql);
				while (rs.next()) {
					Project pro = new Project();
					pro.setId(rs.getInt("id"));
					pro.setName(rs.getString("name"));
					list.add(pro);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
			
		
		
		return list;
	}
	
}



