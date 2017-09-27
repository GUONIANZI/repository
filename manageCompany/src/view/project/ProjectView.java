package view.project;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import util.CallBack;
import util.Constant;
import view.employee.EmployeeView;
import dao.ProjectDao;
import entity.Project;

public class ProjectView {
	
	List<Project> list=new ArrayList<Project>();
	ProjectTableModel model;
	JTable table;
	int select;
	JTextField nameText;
	JTextField proNumsText;
	ProjectDao proDao=new ProjectDao();
	JFrame frame;
	private static ProjectView instance;
	private ProjectView(){	
	}
	public static ProjectView getInstance(){
		if(instance==null){
			instance=new ProjectView();
		}
		return instance;
	}
	public void createFrame(){
		if(frame==null){
			frame=new JFrame();
			init();
		}
		else{
			frame.setVisible(true);
		}
	}

// ����һ������
	public void init(){
	list=proDao.searchAll();
	frame.setSize(800,500);//frame�Ĵ��ڵ���setSize��ʾ
	frame.setTitle("��Ŀ����");
	frame.setLocationRelativeTo(null);
//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel mainPanel=(JPanel)frame.getContentPane();
    BoxLayout box=new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(box);
    
    JPanel jpanel1=new JPanel(new FlowLayout(FlowLayout.CENTER,40,20));
    JPanel jpanel2=new JPanel();
    JPanel jpanel3=new JPanel(new FlowLayout(FlowLayout.CENTER,100,20));
    mainPanel.add(jpanel1);
    mainPanel.add(jpanel2);
    mainPanel.add(jpanel3);
    
 //�ϲ����
    JLabel nameLable=new JLabel();
    nameLable.setText(Constant.BJ_NAME);
    jpanel1.add(nameLable);
    nameText=new JTextField();
    nameText.setPreferredSize(new Dimension(100,30));
    jpanel1.add(nameText);
    
 

    
    JButton searchBtn=new JButton();
    searchBtn.setPreferredSize(new Dimension(70,30));
    searchBtn.setText(Constant.MES_SEARCH);
    jpanel1.add(searchBtn);
    searchBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method prob
		//ÿ��һ�����ݶ������һ���ϴβ�����ݣ�����ڶ��β��ʱ����ֵ�һ�ε����ݡ�	
		    
		     
		     
			String name=nameText.getText();
			
//			try{
//				//������
//				}catch(Exception e){
//				//�쳣����
//				}
//				����������д��󣬾ͻ᷵����д�쳣�Ĵ���
			
			
//		try{
//			age=Integer.parseInt(ageText.getText());
//		}catch(Exception ex){
//			age=0;
//			}
			
		

		Project condition=new Project();
		condition.setName(name);
        list=proDao.searchByCondition(condition);
              refreshTable(list);

		}
		
	});
    	
    
//�м����
    model=new ProjectTableModel(list);
    table=new JTable();
    table.setModel(model);
    //java�ṩ�����ⷽ������Ҫ��table���������Ҫʹ��ProjectTableModel����
    JScrollPane scroll=new JScrollPane(table);
    scroll.setPreferredSize(new Dimension(600,300));
    jpanel2.add(scroll);
     
//�²����
//����-------------------------------------------------------------    
    JButton addBtn=new JButton();
    addBtn.setPreferredSize(new Dimension(70,30));
    addBtn.setText(Constant.MES_ADD);
    jpanel3.add(addBtn);
    addBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
	//���������õĵ�����AddProject add=AddProject.getInstance()��������Ҳֻ��ʾһ��ҳ�档
	//����������һ���ڲ��࣬�ص��ķ��������б�ˢ�£����ô�ֵ�ˣ�������java�ĸ��ھۣ�����ϵ�ԭ��
			AddProjectView add=AddProjectView.getInstance();
			add.createFrame(new CallBack(){
				@Override
		        
				public void call() {
					refreshTable();
				}
				
			});

			
			
			
			
		}
	});
 
 //�޸�------------------------------------------------------------------   
    JButton modifyBtn=new JButton();
    modifyBtn.setPreferredSize(new Dimension(70,30));
    modifyBtn.setText(Constant.MES_MODIFY);
    jpanel3.add(modifyBtn);
    modifyBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method bjb
			
		//selectΪѡ�е���һ�С�
			//���޸ĵ�ʱ���Ȳ�һ��������
//			searchList=oai.searchAll();
		
			select=table.getSelectedRow();
			if(select!=-1){                                             //��searchListѡ����һ�е�ֵ 
				ModifyProjectView modify=ModifyProjectView.getInstance();
				//����new�Ķ��������������С�
				
				Project pro=list.get(select);
				modify.createFrame(pro.getId(),table,new CallBack(){
  
					@Override
					public void call() {
						// TODO Auto-generated method prob
						refreshTable();
					}
				});
			}
			else{
				JOptionPane.showMessageDialog(null, "������ѡ��һ����~����~ ");
			}
		}
	});
    
// ɾ��--------------------------------------------------------------   
    JButton deleateBtn=new JButton();
    deleateBtn.setPreferredSize(new Dimension(70,30));
    deleateBtn.setText(Constant.MES_DELETE);
    jpanel3.add(deleateBtn);
    deleateBtn.addActionListener(new ActionListener() {
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method bjb
			 select=table.getSelectedRow();
			 if(select!=-1){
				 int n = JOptionPane.showConfirmDialog(null, "С������ȷ��Ҫɾ��ô��", "����С����",JOptionPane.YES_NO_OPTION);//i=0/1
			
					 Project pro=new Project();
					 for(int i=0;i<list.size();i++){
						 pro=list.get(select); 
					 }
					 
					 
					 int rs=proDao.delete(pro);
						boolean flag=false;
						if(rs>0){
							flag=true;
							 
						}
				    
				  refreshTable(); 
			
				
			 }else{
				 JOptionPane.showMessageDialog(null, "������ѡ��һ����~����~ ");
			 }
		}
	});
   
    
   
  
    
    
	frame.setVisible(true);
	
	}
	public void refreshTable(){
		
		list=proDao.searchAll();
		model.setData(list);
		model.fireTableDataChanged();
	}
	public void refreshTable(List<Project> list) {
		model.setData(list);
		model.fireTableDataChanged();
	}


}
