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
import entity.Employee;

public class EmployeeDao extends BaseDao {


//  显示全部
	public List<Employee> searchAll() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			
			// 5 执行sql语句
            getStatement();
			ResultSet rs = stat.executeQuery("select s.*,dep.name as depName from employee as s left join department as dep on s.dep_id=dep.id ");
			// 6 处理结果
			while (rs.next()) {
				
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAge(rs.getInt("age"));
				
				
				Department dep=new Department();
				dep.setId(rs.getInt("dep_id"));
				dep.setName(rs.getString("depName"));
				
				emp.setDep(dep);
				list.add(emp);
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
	public Employee searchById(int id) {
		Employee emp = new Employee();
		try {
			// 5 执行sql语句
            getStatement();
			ResultSet rs = stat.executeQuery("select s.*,dep.name as depName from employee as s left join department as dep on s.dep_id=dep.id where s.id="+id);
			// 6 处理结果
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAge(rs.getInt("age"));
				
				Department dep=new Department();
				dep.setId(rs.getInt("dep_id"));
				dep.setName(rs.getString("depName"));
				emp.setDep(dep);
			
				
			}
			

		

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return emp;
	}


	
	//增加----------------------------------------------
	public boolean add(Employee emp) {
		boolean flag=false;
		try {

			// 4 建立sql执行器
            getStatement();

			// 5 执行sql语句
			String sql = "insert into employee (name,sex,age,dep_id) values('" + emp.getName() + "','" + emp.getSex() + "',"+ emp.getAge() + ","+emp.getDep().getId()+")";
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
	
	public boolean update(Employee emp) {
		  boolean flag=true;
			try {

				
	            getStatement();

				
				String sql="update employee set name=?,sex=?,age=?,dep_id=? where id=?";
				         getPreparedStatement(sql);
						 pstat.setString(1,emp.getName());
						 pstat.setString(2,emp.getSex());
						 pstat.setInt(3,emp.getAge());
						 pstat.setInt(4,emp.getDep().getId());
						 pstat.setInt(5,emp.getId());


				int result= pstat.executeUpdate
						();
				
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
	public int delete(Employee emp) {
		//删除就定义成boolean类型的，便于以后自己拿出来同上面的比较
      int result =0;
		try {
			//4，建立sql执行器
            getStatement();
			
			
			//5，执行sql语言
			int id=emp.getId();
			String sql="delete from employee where id="+id;
//			ResultSet rs= stat.executeQuery(sql);//只有查询的时候调executeQuery
			result= stat.executeUpdate(sql);//增删改的时候统一调executeUpdate，且是int类型的，表明的是影响的行数
			
			//6，处理结果集
	
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}

		return result;
	}

	
	//查询-------------------------------------------------------
	public List<Employee> searchByCondition(Employee condition) {
		List<Employee> list = new ArrayList<Employee>();
		
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
//			String sql = "select * from employee 1=1 " + where;
		    String where = "";
			String str = " where ";
			if (!condition.getName().equals("")) {
				where += str + "  s.name like '%" + condition.getName() + "%'";
				str = " and ";
			}
			if (!condition.getSex().equals("")) {
				where += str + "  sex='" + condition.getSex() + "'";
				str = " and ";
			}
			if (condition.getAge() != -1) {
				where += str + "   age=" + condition.getAge();
				str = " and ";
			}
			if (condition.getDep() != null&&condition.getDep().getId()==-1) {
					where += str + "dep_id= 0 or dep_id is null" ;
				}
			else if (condition.getDep() != null&&condition.getDep().getId()!=0) {
				where += str + "dep_id=" + condition.getDep().getId();
			}
			String sql = "select s.*,dep.name as depName from employee as s left join department as dep on s.dep_id=dep.id  " + where;

		  System.out.println(sql);
		  
			 try {
				rs = stat.executeQuery(sql);
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setSex(rs.getString("sex"));
					emp.setAge(rs.getInt("age"));
					
					Department dep=new Department();
					dep.setId(rs.getInt("dep_id"));
					dep.setName(rs.getString("depName"));
					emp.setDep(dep);
					list.add(emp);
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



