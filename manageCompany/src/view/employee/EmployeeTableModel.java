package view.employee;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Employee;

public class EmployeeTableModel extends AbstractTableModel {
	List<Employee> list=new ArrayList<Employee>();
public EmployeeTableModel(List<Employee> list){
	this.list=list;

}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex==0){
			return list.get(rowIndex).getId();
		}
		if(columnIndex==1){
			return list.get(rowIndex).getName();
		}
        if(columnIndex==2){
			return list.get(rowIndex).getSex();
		}
        if(columnIndex==3){
	        return list.get(rowIndex).getAge();
        }
        if(columnIndex==4){
	        return list.get(rowIndex).getDep().getName();
        }
       
        else{
        return null;
        }
	}
	@Override
	  public String getColumnName(int column) {
		  if(column==0){
	    	  return "id";
	    	  
	      }
	      if(column==1){
	    	  return "姓名";
	    	  
	      }
          if(column==2){
        	  return "性别";
	    	  
	      }
          if(column==3){
        	  return "年龄";
          }
          if(column==4){
        	  return "部门";
          }
         
	        return null;
	    }
		public void setData(List<Employee> list){
			this.list=list;
		}

}
