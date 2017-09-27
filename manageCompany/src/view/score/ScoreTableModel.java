package view.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import entity.Score;

public class ScoreTableModel extends AbstractTableModel {
	List<Score> list=new ArrayList<Score>();
	Set<Score> saveSet;
	
public ScoreTableModel(List<Score> list,Set<Score> saveSet){
	this.list=list;
	this.saveSet=saveSet;

}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	   public boolean isCellEditable(int rowIndex, int columnIndex) {
		   if(columnIndex==3){//第四列可以被选中
			   return true;
		   }
	        return false;
	    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		if(columnIndex==0){
			return list.get(rowIndex).getEmp().getName();
		}
        if(columnIndex==1){
			return list.get(rowIndex).getEmp().getDep().getName();
		}
        if(columnIndex==2){
	        return list.get(rowIndex).getPro().getName();
        }
        if(columnIndex==3){
	        return list.get(rowIndex).getScore();
        }
 
       
        else{
        return null;
        }
	}
	@Override
	  public String getColumnName(int column) {
		
	      if(column==0){
	    	  return "姓名";
	    	  
	      }
          if(column==1){
        	  return "部门";
	    	  
	      }
          if(column==2){
        	  return "项目";
          }
          if(column==3){
        	  return "绩效";
          }
       
         
	        return null;
	    }
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Object aValue 获得输入的值----------------------------------------------------------
				list.get(rowIndex).setScore(Integer.parseInt((String) aValue));
				// boolean flag = false;
				// int i = 0;
				// for (; i < saveList.size(); i++) {
				//
				// if (saveList.get(i) == list.get(rowIndex)) {
				// flag = true;
				// break;
				// }
				// }
				// if (flag) {
				// //saveList.set(i, list.get(rowIndex));
				// } else {
				// saveList.add(list.get(rowIndex));
				//
				// }

				saveSet.add(list.get(rowIndex));
			}
	

		public void setData(List<Score> list){
			this.list=list;
		}

}
