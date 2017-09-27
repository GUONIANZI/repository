package view.project;

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
import dao.ProjectDao;
import entity.Project;

public class ModifyProjectView {
	

	JFrame frame;
	JTextField nameText;
	JTable table;
	Project pro;
	ProjectDao proDao=new ProjectDao();
	CallBack callBack;
	private static ModifyProjectView instance;
	
	
	private ModifyProjectView(){
		
		
	}
	
	
    public static ModifyProjectView getInstance(){
		
		if(instance==null){
			instance=new ModifyProjectView();
		}
		return instance;
	}
    

    public void createFrame(int Id,JTable table,CallBack callBack){
		this.table=table;
		this.callBack=callBack;
		this.pro=proDao.searchById(Id);

		if(frame==null){
			frame=new JFrame();
			init();
		}
		else{
		    nameText.setText(pro.getName());//��pro���õ�ֵ��Ȼ����nametext������������֡�
//	        frame=new JFrame();
//	        init();
			frame.setVisible(true);
		}
	}
	
	
	
	public void init(){
		frame=new JFrame();
		frame.setSize(300,400);//frame�Ĵ��ڵ���setSize��ʾ
		frame.setTitle("�����ֵ��޸Ĺ���");
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
	    nameLable.setText("����");
	    jpanel1.add(nameLable);
	    nameText=new JTextField();
	    nameText.setPreferredSize(new Dimension(100,30));
	    nameText.setText(pro.getName());//��pro���õ�ֵ��Ȼ����nametext������������֡�
	    jpanel1.add(nameText);
	    

	    
	    JButton addBtn=new JButton();
	    addBtn.setPreferredSize(new Dimension(70,30));
	    addBtn.setText("����");
	    jpanel4.add(addBtn);
	    addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pro.setName(nameText.getText());
				boolean rs=proDao.update(pro);
                ShowMessage.show(rs,Constant.MES_MODIFY);
				frame.dispose();
                callBack.call();
				JOptionPane.showMessageDialog(null, "С���������޸ĳɹ�~ ");
			}
		});
			
	    
		frame.setVisible(true);
}

}