package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Project;



public class ManageProject2DepartmentDao extends BaseDao {

	
	public List<Project> searchByDepId(int depId) {
		List<Project> list = new ArrayList<Project>();
		try {

			// 5 执行sql语句
			getStatement();
			
			ResultSet rs = stat.executeQuery("select pro.* from department as dep inner join m_dep_pro as m on dep.id=m.dep_id inner join project as pro on m.pro_id=pro.id where dep.id="+ depId);
			// 6 处理结果
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				list.add(pro);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return list;

	}

	public List<Project> searchByNotDepId(int depId) {

		List<Project> list = new ArrayList<Project>();
		try {

			// 5 执行sql语句
			getStatement();
			ResultSet rs = stat.executeQuery("select * from project where id not in ( select pro.id from department as dep inner join m_dep_pro as m on dep.id=m.dep_id inner join project as pro on m.pro_id=pro.id where dep.id="+ depId + ")");
			// 6 处理结果
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				list.add(pro);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return list;

	}

	public boolean add(int depId, int proId) {
		boolean flag = false;

		try {
			getStatement();
			String sql = "insert into m_dep_pro values("+depId+","+proId+")";
			int result = stat.executeUpdate(sql);
			if(result>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public boolean delete(int depId, int proId) {
		boolean flag = false;

		try {
			getStatement();
			String sql = "delete from m_dep_pro where dep_id = "+depId+" and pro_id= "+proId+"";
			int result = stat.executeUpdate(sql);
			if(result>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
}
