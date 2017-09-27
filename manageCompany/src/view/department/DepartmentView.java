package view.department;

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
import dao.DepartmentDao;
import entity.Department;

public class DepartmentView {
	
	List<Department> list=new ArrayList<Department>();
	DepartmentTableModel model;
	JTable table;
	JTextField nameText;
	JTextField depNumsText;
	DepartmentDao depDao=new DepartmentDao();
	JFrame frame;
	private static DepartmentView instance;
	private DepartmentView(){
		
	}

	public static DepartmentView getInstance(){
		if(instance==null){
			instance=new DepartmentView();
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
	list=depDao.searchAll();
	
	frame.setSize(800,500);//frame�Ĵ��ڵ���setSize��ʾ
	frame.setTitle("���Ź���");
	frame.setLocationRelativeTo(null);
//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel mainPanel=(JPanel)frame.getContentPane();
    BoxLayout box=new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(box);
    
    JPanel jpanel1=new JPanel(new FlowLayout(FlowLayout.CENTER,40,20));
    JPanel jpanel2=new JPanel();
    JPanel jpanel3=new JPanel(new FlowLayout(FlowLayout.CENTER,60,20));
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
			// TODO Auto-generated method depb
			String name=nameText.getText();
			int depNums=-1;
			if (!depNumsText.getText().equals("")) {
				depNums = Integer.parseInt(depNumsText.getText());
			}

		Department condition=new Department();
		condition.setName(name);
        list=depDao.searchByCondition(condition);
              refreshTable(list);

		}
		
	});
    	
    
//�м����
    model=new DepartmentTableModel(list);
    table=new JTable();
    table.setModel(model);
    //java�ṩ�����ⷽ������Ҫ��table���������Ҫʹ��DepartmentTableModel����
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
	//���������õĵ�����AddDepartment add=AddDepartment.getInstance()��������Ҳֻ��ʾһ��ҳ�档
	//����������һ���ڲ��࣬�ص��ķ��������б�ˢ�£����ô�ֵ�ˣ�������java�ĸ��ھۣ�����ϵ�ԭ��
			AddDepartmentView add=AddDepartmentView.getInstance();
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
			// TODO Auto-generated method depb
			
		//selectΪѡ�е���һ�С�
			//���޸ĵ�ʱ���Ȳ�һ��������
//			searchList=oai.searchAll();
		   
			int select=table.getSelectedRow();
			if(select!=-1){                                             //��searchListѡ����һ�е�ֵ 
				ModifyDepartmentView modify=ModifyDepartmentView.getInstance();
				//����new�Ķ��������������С�
				
				Department dep=list.get(select);
				modify.createFrame(dep.getId(),table,new CallBack(){
  
					@Override
					public void call() {
						// TODO Auto-generated method depb
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
			// TODO Auto-generated method depb
			int select=table.getSelectedRow();
			 if(select!=-1){
				 int n = JOptionPane.showConfirmDialog(null, "С������ȷ��Ҫɾ��ô��", "����С����",JOptionPane.YES_NO_OPTION);//i=0/1
			
					 Department dep=new Department();
					 for(int i=0;i<list.size();i++){
						 dep=list.get(select); 
					 }
					 
					 
					 int rs=depDao.delete(dep);
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
    
    JButton depBtn=new JButton();
    depBtn.setPreferredSize(new Dimension(110,30));
    depBtn.setText("���Ź���");
    jpanel3.add(depBtn);
    depBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int select=table.getSelectedRow();
			if(select<0){
				JOptionPane.showMessageDialog(null, "������ѡ��һ����~����~ ");
				
			}else{
//				Department dep=list.get(select);
				ManageProject2DepartmentView deptsub=new ManageProject2DepartmentView(list.get(select));
				
		        deptsub.init();
			}
		}
	});
   
	frame.setVisible(true);
	
	}
	public void refreshTable(){
		list=depDao.searchAll();
		model.setData(list);
		model.fireTableDataChanged();
	}
	public void refreshTable(List<Department> list) {
		model.setData(list);
		model.fireTableDataChanged();
	}


}
