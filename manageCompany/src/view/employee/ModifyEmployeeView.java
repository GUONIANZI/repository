package view.employee;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import util.CallBack;
import util.Constant;
import view.ShowMessage;
import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Department;
import entity.Employee;

public class ModifyEmployeeView {
	

	JFrame frame;
	JTextField nameText;
	JTextField sexText;
	JTextField ageText;

	JTable table;
	Employee emp;
	EmployeeDao empDao=new EmployeeDao();
	CallBack callBack;
	private static ModifyEmployeeView instance;
	
	JComboBox depBox;
	DepartmentDao depDao=new DepartmentDao();
	List<Department> depList;
	
	private ModifyEmployeeView(){
		
		
	}
	
	
    public static ModifyEmployeeView getInstance(){
		
		if(instance==null){
			instance=new ModifyEmployeeView();
		}
		return instance;
	}
    

    public void createFrame(int id,JTable table,CallBack callBack){
		this.table=table;
		this.callBack=callBack;
		this.emp=empDao.searchById(id);

		if(frame==null){
			frame=new JFrame();
			init();
		}
		else{
		    nameText.setText(emp.getName());//从emp中拿到值，然后在nametext上生成这个名字。
		    sexText.setText(emp.getSex());
	        ageText.setText(""+(emp.getAge()));//字符传拼接也可以将int类型转换为String类型或者是String.valueOf()   
	        setDepBox();
			frame.setVisible(true);
		}
	}
	
	
	
	public void init(){
		frame=new JFrame();
		frame.setSize(300,400);//frame的窗口得用setSize显示
		frame.setTitle(Constant.STU_MODIFY_TITLE);
		frame.setLocationRelativeTo(null);
		
		JPanel mainPanel=(JPanel)frame.getContentPane();//
	    BoxLayout box=new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
	    mainPanel.setLayout(box);
	    
	    JPanel jpanel1=new JPanel();
	    JPanel jpanel2=new JPanel();
	    JPanel jpanel3=new JPanel();
	    JPanel jpanel4=new JPanel();
	    JPanel jpanel5=new JPanel();


	    mainPanel.add(jpanel1);
	    mainPanel.add(jpanel2);
	    mainPanel.add(jpanel3);
	    mainPanel.add(jpanel4);
	    mainPanel.add(jpanel5);
	    
	 //上层面板
	    JLabel nameLable=new JLabel();
	    nameLable.setText(Constant.STU_NAME);
	    jpanel1.add(nameLable);
	    nameText=new JTextField();
	    nameText.setPreferredSize(new Dimension(100,30));
	    nameText.setText(emp.getName());//从emp中拿到值，然后在nametext上生成这个名字。
	    jpanel1.add(nameText);
	    
	    JLabel sexLable=new JLabel();
	    sexLable.setText(Constant.STU_SEX);
	    jpanel2.add(sexLable);
	    sexText=new JTextField();
	    sexText.setPreferredSize(new Dimension(100,30));
	    sexText.setText(emp.getSex());

	    jpanel2.add(sexText);
	    
	    JLabel ageLable=new JLabel();
	    ageLable.setText(Constant.STU_AGE);
	    jpanel3.add(ageLable);
	    ageText=new JTextField();
	    ageText.setPreferredSize(new Dimension(100,30));
        ageText.setText(""+(emp.getAge()));//字符传拼接也可以将int类型转换为String类型或者是String.valueOf()
	    jpanel3.add(ageText);
	    
	    JLabel depLable=new JLabel();
	    depLable.setText("部门");
	    jpanel4.add(depLable);
	    
	    depBox = new JComboBox();
		depList = depDao.searchAll();
		depBox.addItem("请选择部门");
		//循环添加所有的选项
		for(Department dep:depList){
			depBox.addItem(dep.getName());
		}
		setDepBox();
		
		depBox.setPreferredSize(new Dimension(150, 40));
		jpanel4.add(depBox);
		
		
		//按钮保存部分
		jpanel5.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		JButton savebtn = new JButton();
		savebtn.setPreferredSize(new DimensionUIResource(120, 40));
		savebtn.setText("修改");
		jpanel5.add(savebtn);
		//插入监听
		savebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String sex = sexText.getText();
				int age = Integer.parseInt(ageText.getText());
				emp.setName(name);
				emp.setSex(sex);
				emp.setAge(age);
				int index = depBox.getSelectedIndex();
				System.out.println(index);
				Department dep = new Department();
				if(index > 0){
				 dep = depList.get(index-1);
				}
			    emp.setDep(dep);
				boolean rs = empDao.update(emp);
				ShowMessage.show(rs, Constant.MES_MODIFY);
				frame.dispose();
				callBack.call();
				//利用回调代替调用model。
				//model.fireTableStructureChanged();//调用STmodel中的model的在执行一遍的方法
			}
		});
		    frame.setVisible(true);
        }
	//判断当前选的修改的是哪一个
	private void setDepBox(){
		depBox.setSelectedIndex(0);
		for(int i = 0;i<depList.size();i++)
		{
			if(depList.get(i).getId()==emp.getDep().getId()){
				depBox.setSelectedIndex(i+1);
			}
		}
	}

}
