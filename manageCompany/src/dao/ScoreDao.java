package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entity.Department;
import entity.Score;
import entity.Employee;
import entity.Project;

public class ScoreDao extends BaseDao{

	public List<Score>  searchAll() {
		List<Score> list = new ArrayList<Score>();
		try {
			
			
            getStatement();
			ResultSet rs = stat.executeQuery("select * from  v_emp_dep_pro_score");
			while (rs.next()) {
				Score sc = new Score();
				sc.setId(rs.getInt("scId"));
				if (rs.getString("score") != null) {
					sc.setScore(rs.getInt("score"));
				} else {
					sc.setScore(-1);

				}
				Employee emp = new Employee();
				emp.setId(rs.getInt("empId"));
				emp.setName(rs.getString("empName"));
				Department dep = new Department();
				dep.setId(rs.getInt("depId"));
				dep.setName(rs.getString("depName"));
				emp.setDep(dep);
				sc.setEmp(emp);
				Project pro = new Project();
				pro.setId(rs.getInt("proId"));
				pro.setName(rs.getString("proName"));
				sc.setPro(pro);
				list.add(sc);
				/*Empdent emp = new Empdent();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				BanJi dep=new BanJi();
                dep.setName(rs.getString("depname"));
                Project pro=new Project();
                pro.setName(rs.getString("proname"));
                Score sc=new Score();
                sc.setScore(rs.getInt("score"));
                sc.setGrade(rs.getString("grade"));
                sc.setEmp(emp);
                emp.setDep(dep);
                sc.setPro(pro);
				list.add(sc);*/
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}
	
	
//	public List<Score> searchByCondition(Score condition) {
//		List<Score> list = new ArrayList<Score>();
//		
//		  getStatement();
//		    String where = "";
//			String str = " where ";
//			if (!condition.getEmp().getName().equals("")) {
//				where += str + "  emp.name = '" + condition.getEmp().getName() + "'";
//				str = " and ";
//			}
//			if (condition.getEmp().getDep()!=null&&condition.getEmp().getDep().getId()==-1) {
//				where += str + "  dep.name = '" + condition.getEmp().getDep().getName()+ "'";
//				str = " and ";
//			}
//			if (condition.getPro()!=null&&condition.getPro().getId()==-1) {
//				where += str + "  pro.name ='" + condition.getPro().getName()+"'";
//				str = " and ";
//			}
//
//			String sql = "select emp.id,emp.name as empname,dep.name as depname,pro.name as proname,sc.score as score from empdent as emp inner join banji as dep on emp.dep_id=dep.id inner join m_dep_pro as m on dep.id=m.dep_id inner join sudepect as pro on m.pro_id=pro.id left  join score as sc on emp.id=sc.emp_id and pro.id=sc.pro_id " + where;
//		    System.out.println(sql);
//			try {
//				rs = stat.executeQuery(sql);
//				while (rs.next()) {
//					Empdent emp = new Empdent();
//					emp.setName(rs.getString("empname"));
//
//					
//					BanJi dep=new BanJi();
//					dep.setName(rs.getString("depname"));
//					
//					Project pro=new Project();
//					pro.setName(rs.getString("proName"));
//
//					Score sc=new Score();
//					sc.setScore(rs.getInt("score"));
//					list.add(condition);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally{
//				closeAll();
//			}
//			
//		
//		
//		return list;
//	}
	public List<Score> searchByCondition(Score condition) {

		List<Score> list = new ArrayList<Score>();

		try {

			getStatement();
			String where = "";

			if (!condition.getEmp().getName().equals("")) {
				where += " and  empName='" + condition.getEmp().getName() + "'";
			}
			if (condition.getEmp().getDep().getId() != -1) {
				where += " and  depId=" + condition.getEmp().getDep().getId();

			}
			if (condition.getPro().getId() != -1) {
				where += " and  proId=" + condition.getPro().getId();

			}

			
			String sql="select * from v_emp_dep_pro_score where 1=1"+where ;
			System.out.println(sql);
			rs = stat.executeQuery(sql);
		
			while (rs.next()) {

				Score sc = new Score();
				sc.setId(rs.getInt("scId"));
				if (rs.getString("score") != null) {
					sc.setScore(rs.getInt("score"));
				} else {
					sc.setScore(-1);

				}
				Employee emp = new Employee();
				emp.setId(rs.getInt("empId"));
				emp.setName(rs.getString("empName"));
				Department dep = new Department();
				dep.setId(rs.getInt("depId"));
				dep.setName(rs.getString("depName"));
				emp.setDep(dep);
				sc.setEmp(emp);
				Project pro = new Project();
				pro.setId(rs.getInt("proId"));
				pro.setName(rs.getString("proName"));
				sc.setPro(pro);
				list.add(sc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return list;
	}
	
	public boolean save(Set<Score> set) {
		boolean flag = true;
		for (Score sc : set) {

			if (sc.getId() == 0) {
				flag = add(sc);
			} else {

				flag = update(sc);
			}

			if (flag == false) {
				break;
			}

		}

		return flag;
	}

	private boolean update(Score sc) {
		boolean flag = false;
		try {
			String sql = "update score set score=? where id=?";
			getPreparedStatement(sql);
			pstat.setInt(1, sc.getScore());
			pstat.setInt(2, sc.getId());
			int result = pstat.executeUpdate();
			if (result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return flag;
	}

	private boolean add(Score sc) {
		boolean flag = false;

		try {
			String sql = "insert into score (emp_id,pro_id,score) values(?,?,?)";
			getPreparedStatement(sql);
			pstat.setInt(1, sc.getEmp().getId());
			pstat.setInt(2, sc.getPro().getId());
			pstat.setInt(3, sc.getScore());

			int result = pstat.executeUpdate();
			if (result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return flag;
	}



}
