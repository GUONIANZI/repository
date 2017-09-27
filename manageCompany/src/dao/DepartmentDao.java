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

public class DepartmentDao extends BaseDao{


	
//  ��ʾȫ��
	public List<Department> searchAll() {
		List<Department> list = new ArrayList<Department>();
		try {
			
			// 5 ִ��sql���
            getStatement();
			ResultSet rs = stat.executeQuery("select * from department");
			// 6 ������
			while (rs.next()) {
				
				Department dep = new Department();
				dep.setId(rs.getInt("id"));
				dep.setName(rs.getString("name"));
				list.add(dep);
			}
			

		

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}
	
	//��ѯid
	public Department searchById(int Id) {
		Department dep = new Department();
		try {
			
			// 5 ִ��sql���
            getStatement();
			ResultSet rs = stat.executeQuery("select * from department where id="+Id);
			// 6 ������
			while (rs.next()) {
				dep.setId(rs.getInt("id"));
				dep.setName(rs.getString("name"));
			
				
			}
			

		

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return dep;
	}


	
	//����----------------------------------------------
	public boolean add(Department dep) {
		boolean flag=false;
		try {

			// 4 ����sqlִ����
            getStatement();

			// 5 ִ��sql���
			String sql = "insert into department (name) values('" + dep.getName() +  "')";
			int result = stat.executeUpdate(sql);
			// 6 ������
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

	
	//�޸�----------------------------------------------------
	
	public boolean update(Department dep) {
		  boolean flag=true;
			try {

				
				String sql="update department set name=? where id=?";
				         getPreparedStatement(sql);
						 pstat.setString(1,dep.getName());
						 pstat.setInt(2,dep.getId());

//				int id=dep.getId();		 
//				String sql="update department set name='" +dep.getName()+ "', sex='"+dep.getSex()+"',age ='"+dep.getAge()+"' where id="+id;
//				ResultSet rs= stat.executeQuery(sql);//ֻ�в�ѯ��ʱ���executeQuery
				int result= pstat.executeUpdate
						
						();//��ɾ�ĵ�ʱ��ͳһ��executeUpdate������int���͵ģ���������Ӱ�������
				
				//6����������
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
	
  
	//�h��------------------------------------------------------------
	public int delete(Department dep) {
		//ɾ���Ͷ����boolean���͵ģ������Ժ��Լ��ó���ͬ����ıȽ�
      int result =0;
		try {
			//4������sqlִ����
            getStatement();

			//5��ִ��sql����
			int id=dep.getId();
			String sql="delete from department where id="+id;
//			ResultSet rs= stat.executeQuery(sql);//ֻ�в�ѯ��ʱ���executeQuery
			result= stat.executeUpdate(sql);//��ɾ�ĵ�ʱ��ͳһ��executeUpdate������int���͵ģ���������Ӱ�������
	

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}

		return result;
	}

	
	//��ѯ-------------------------------------------------------
	public List<Department> searchByCondition(Department condition) {
		List<Department> list = new ArrayList<Department>();
		
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
//			String sql = "select * from department 1=1 " + where;
		  String where = "";
			String str = " where ";
			if (!condition.getName().equals("")) {

				where += str + "  name like '" + condition.getName() + "'";
				str = " and ";
			}


			String sql = "select * from department  " + where;

		  System.out.println(sql);
		  
			 try {
				rs = stat.executeQuery(sql);
				while (rs.next()) {
					Department dep = new Department();
					dep.setId(rs.getInt("id"));
					dep.setName(rs.getString("name"));
					list.add(dep);
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



