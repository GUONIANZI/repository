package view.department;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.CallBack;
import util.Constant;
import view.ShowMessage;
import dao.DepartmentDao;
import entity.Department;

public class AddDepartmentView {
	JTextField nameText;

	JFrame frame;
	CallBack callBack;
	DepartmentDao depDao=new DepartmentDao();
	private static AddDepartmentView instance;
	
	private AddDepartmentView(){
		


	
	}
	
	public static AddDepartmentView getInstance(){
		
		if(instance==null){
			instance=new AddDepartmentView();
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
	frame.setTitle(Constant.BJ_ADD_TITLE);
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
    nameLable.setText(Constant.BJ_NAME);
    jpanel1.add(nameLable);
    nameText=new JTextField();
    nameText.setPreferredSize(new Dimension(100,30));
    jpanel1.add(nameText);
    

    

    
    JButton addBtn=new JButton();
    addBtn.setPreferredSize(new Dimension(70,30));
    addBtn.setText(Constant.MES_SAVE);
    jpanel4.add(addBtn);
    addBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method depb

			String name=nameText.getText();
			nameText.setText("");

			Department dep=new Department();
			dep.setName(name);


			boolean rs=depDao.add(dep);
		    ShowMessage.show(rs,Constant.MES_ADD); 
			frame.dispose();
			callBack.call();
			
			
			JOptionPane.showMessageDialog(null, "小主，您已保存成功~ ");
		}
	});
    
    


	
	frame.setVisible(true);
	
	}
	
	
}
