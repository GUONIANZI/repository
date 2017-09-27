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
	frame.setSize(300,400);//frame�Ĵ��ڵ���setSize��ʾ
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
    
 //�ϲ����
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

			//set��������Ҫ�Ӷ�������˼����˭��������һ��ֵ��
			//get�������ﲻ��Ҫ�Ӷ�������˼�Ǵ�˭����õ�ֵ��
			//һ�㶼��set����getһ��ʹ�ã����Բο���������AddProject��ModifyProject��
//			pro.setName(nameText.getText());
//			pro.setSex(sexText.getText());
//			pro.setAge(Integer.parseInt(ageText.getText()));

//			����list�Ѿ��������ǵ�ֵ�ˣ�����list�Ǹ���list���۵�����list�����Եô�ֵ������
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
			
			
			JOptionPane.showMessageDialog(null, "С�������ѱ���ɹ�~ ");
		}
	});
    
    


	
	frame.setVisible(true);
	
	}
	
	
}
