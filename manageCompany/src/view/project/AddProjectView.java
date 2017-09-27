package view.project;

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
import dao.ProjectDao;
import entity.Project;

public class AddProjectView {
	JTextField nameText;

	JFrame frame;
	CallBack callBack;
	ProjectDao proDao=new ProjectDao();
	private static AddProjectView instance;
	
	private AddProjectView(){
		


	
	}
	
	public static AddProjectView getInstance(){
		
		if(instance==null){
			instance=new AddProjectView();
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
			// TODO Auto-generated method bjb

			String name=nameText.getText();
			nameText.setText("");

			Project pro=new Project();
			pro.setName(name);

			//set的括号里要加东西，意思是在谁那里设置一个值。
			//get的括号里不需要加东西，意思是从谁那里得到值。
			//一般都是set搭配get一起使用，可以参考这个包里的AddProject和ModifyProject。
//			pro.setName(nameText.getText());
//			pro.setSex(sexText.getText());
//			pro.setAge(Integer.parseInt(ageText.getText()));

//			现在list已经有了咱们的值了，但是list是个新list，咱得用老list，所以得传值过来用
//			int rs=oai.add(pro);
//				boolean flag=false;
//				if(rs>0){
//					flag=true;
//					 
//				}
			boolean rs=proDao.add(pro);
		    ShowMessage.show(rs,Constant.MES_ADD); 
			frame.dispose();
			callBack.call();
			
			
			JOptionPane.showMessageDialog(null, "小主，您已保存成功~ ");
		}
	});
    
    


	
	frame.setVisible(true);
	
	}
	
	
}
