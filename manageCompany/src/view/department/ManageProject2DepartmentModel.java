package view.department;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Project;

public class ManageProject2DepartmentModel extends AbstractTableModel {
	List<Project> list=new ArrayList<Project>();
public ManageProject2DepartmentModel(List<Project> list){
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
		return 2;
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
	    	  return "Ãû³Æ";
	    	  
	      }


	        return null;
	    }
		public void setData(List<Project> list){
			this.list=list;
		}

}
