package view.department;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import util.CallBack;
import util.Constant;
import view.ShowMessage;
import dao.DepartmentDao;
import entity.Department;

public class ModifyDepartmentView {
	
	JFrame frame;
	JTextField nameText;
	JTable table;
	Department dep;
	DepartmentDao depDao=new DepartmentDao();
	CallBack callBack;
	private static ModifyDepartmentView instance;
	
	
	private ModifyDepartmentView(){
		
		
	}
	
	
    public static ModifyDepartmentView getInstance(){
		
		if(instance==null){
			instance=new ModifyDepartmentView();
		}
		return instance;
	}
    

    public void createFrame(int Id,JTable table,CallBack callBack){
		this.table=table;
		this.callBack=callBack;
		this.dep=depDao.searchById(Id);

		if(frame==null){
			frame=new JFrame();
			init();
		}
		else{
		    nameText.setText(dep.getName());//从dep中拿到值，然后在nametext上生成这个名字。

			frame.setVisible(true);
		}
	}
	
	
	
	public void init(){
		frame=new JFrame();
		frame.setSize(300,400);//frame的窗口得用setSize显示
		frame.setTitle("郭念字的修改功能");
		frame.setLocationRelativeTo(null);
		
		JPanel mainPanel=(JPanel)frame.getContentPane();//
	    BoxLayout box=new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
	    mainPanel.setLayout(box);
	    
	    JPanel jpanel1=new JPanel();
	    JPanel jpanel2=new JPanel();
	    JPanel jpanel3=new JPanel();
	    JPanel jpanel4=new JPanel();

	    mainPanel.add(jpanel1);
	    mainPanel.add(jpanel2);
	    mainPanel.add(jpanel3);
	    mainPanel.add(jpanel4);
	    
	 //上层面板
	    JLabel nameLable=new JLabel();
	    nameLable.setText("姓名");
	    jpanel1.add(nameLable);
	    nameText=new JTextField();
	    nameText.setPreferredSize(new Dimension(100,30));
	    nameText.setText(dep.getName());//从dep中拿到值，然后在nametext上生成这个名字。
	    jpanel1.add(nameText);
	    
	  
	 
	    
	    JButton addBtn=new JButton();
	    addBtn.setPreferredSize(new Dimension(70,30));
	    addBtn.setText("保存");
	    jpanel4.add(addBtn);
	    addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method depb
//				list.remove(select);
//			    list=oai.searchAll();
				dep.setName(nameText.getText());//我们现在要改值了，先从文本框中拿到我们写的值，然后在dep上生成name
//			    list.add(select,dep);
//				int rs=oai.update(dep);
//				boolean flag=false;
//				if(rs>0){      老朱把dao层里面的修改改成了boolean类型的，就不用来回的定义flag了。
//					flag=true;
//					
//				}
				
				boolean rs=depDao.update(dep);
                ShowMessage.show(rs,Constant.MES_MODIFY);
				frame.dispose();
                callBack.call();
				JOptionPane.showMessageDialog(null, "小主，您已修改成功~ ");
			}
		});
			
	    
		frame.setVisible(true);
}

}