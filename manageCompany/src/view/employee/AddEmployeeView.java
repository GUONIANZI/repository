package view.employee;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.CallBack;
import util.Constant;
import view.ShowMessage;
import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Department;
import entity.Employee;

public class AddEmployeeView {
	JTextField nameText;
	JTextField sexText;
	JTextField ageText;
	JTextField depText;
	JComboBox depBox;


	JFrame frame;
	CallBack callBack;
	EmployeeDao empDao=new EmployeeDao();
	private static AddEmployeeView instance;
	DepartmentDao depDao=new DepartmentDao();
	List<Department> depList;
	
	private AddEmployeeView(){
		


	
	}
	
	public static AddEmployeeView getInstance(){
		
		if(instance==null){
			instance=new AddEmployeeView();
		}
		return instance;
	}
	
	public  void createFrame(CallBack callBack){
		this.callBack=callBack;
		if(frame==null){
			frame=new JFrame();
			init();
		}
		else{
			frame.setVisible(true);
		}
	}
	
	
	public void init(){
	frame=new JFrame();
	frame.setSize(300,400);//frame的窗口得用setSize显示
	frame.setTitle(Constant.STU_ADD_TITLE);
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
    jpanel1.add(nameText);
    
    JLabel sexLable=new JLabel();
    sexLable.setText(Constant.STU_SEX);
    jpanel2.add(sexLable);
    sexText=new JTextField();
    sexText.setPreferredSize(new Dimension(100,30));
    jpanel2.add(sexText);
    
    JLabel ageLable=new JLabel();
    ageLable.setText(Constant.STU_AGE);
    jpanel3.add(ageLable);
    ageText=new JTextField();
    ageText.setPreferredSize(new Dimension(100,30));
    jpanel3.add(ageText);
    
    
    
    JLabel depLable=new JLabel();
    depLable.setText("部门");
    jpanel4.add(depLable);
    
    depBox=new JComboBox();
    //查到所有的班级放到depList中去
    
    depList=depDao.searchAll();
    depBox.addItem("请选择部门");
    
    
    //逐元循环把数据加进去
    for(Department dep:depList){
    	depBox.addItem(dep.getName());
    }
    
    
    depBox.setPreferredSize(new Dimension(100,30));
    jpanel4.add(depBox);
    
    
    JButton addBtn=new JButton();
    addBtn.setPreferredSize(new Dimension(70,30));
    addBtn.setText(Constant.MES_SAVE);
    jpanel5.add(addBtn);
    addBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method empb

			String name=nameText.getText();
			nameText.setText("");
			String sex=sexText.getText();
			sexText.setText("");
			int age=Integer.parseInt(ageText.getText());
			ageText.setText("");

			Employee emp=new Employee();
			emp.setName(name);
			emp.setSex(sex);
			emp.setAge(age);
			
            //拿到我们所选的数据
            int index=depBox.getSelectedIndex();
            Department dep=new Department();
            if(index>0){
            	index=index-1;
                 dep=depList.get(index);

            }
            emp.setDep(dep);
            
            
			boolean rs=empDao.add(emp);
		    ShowMessage.show(rs,Constant.MES_ADD); 
			frame.dispose();
			callBack.call();
			
			
			JOptionPane.showMessageDialog(null, "小主，您已保存成功~ ");
		}
	});
    
    


	
	frame.setVisible(true);
	
	}
	
	
}
