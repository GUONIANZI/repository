package view.employee;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import dao.EmployeeDao;
import entity.Department;
import entity.Employee;

public class EmployeeView {
	
	List<Employee> list=new ArrayList<Employee>();
	EmployeeTableModel model;
	JTable table;
	int select;
	JTextField nameText;
	JTextField sexText;
	JTextField ageText; 
	JComboBox depBox;
	List<Department> depList;
	EmployeeDao empDao=new EmployeeDao();
	JFrame frame;
	private static EmployeeView instance;
	DepartmentDao depDao=new DepartmentDao();
private EmployeeView(){
	
}

public static EmployeeView getInstance(){
	if(instance==null){
		instance=new EmployeeView();
	}
	return instance;
}


public void createFrame(){
	if(frame==null){
		frame=new JFrame();
		init();
	}
	else{
		refreshTable();
		frame.setVisible(true);
	}
}

// ����һ������
	public void init(){
	list=empDao.searchAll();
	frame.setSize(800,500);//frame�Ĵ��ڵ���setSize��ʾ
	frame.setTitle("Ա������");
	frame.setLocationRelativeTo(null);
//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel mainPanel=(JPanel)frame.getContentPane();
    BoxLayout box=new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(box);
    
    JPanel jpanel1=new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
    JPanel jpanel2=new JPanel();
    JPanel jpanel3=new JPanel(new FlowLayout(FlowLayout.CENTER,100,20));
    mainPanel.add(jpanel1);
    mainPanel.add(jpanel2);
    mainPanel.add(jpanel3);
    
 //�ϲ����
    JLabel nameLable=new JLabel();
    nameLable.setText(Constant.STU_NAME);
    jpanel1.add(nameLable);
    nameText=new JTextField();
    nameText.setPreferredSize(new Dimension(100,30));
    jpanel1.add(nameText);
    
    JLabel sexLable=new JLabel();
    sexLable.setText(Constant.STU_SEX);
    jpanel1.add(sexLable);
    sexText=new JTextField();
    sexText.setPreferredSize(new Dimension(100,30));
    jpanel1.add(sexText);
    
    JLabel ageLable=new JLabel();
    ageLable.setText(Constant.STU_AGE);
    jpanel1.add(ageLable);
    ageText=new JTextField();
    ageText.setPreferredSize(new Dimension(100,30));
    jpanel1.add(ageText);
    
    JLabel depLable=new JLabel();
    depLable.setText("����");
    jpanel1.add(depLable);
    
    depBox=new JComboBox();
    //�鵽���еİ༶�ŵ�depList��ȥ
    
    depList=depDao.searchAll();
    depBox.addItem("��ѡ����");
    //��Ԫѭ�������ݼӽ�ȥ
    for(Department dep:depList){
    	depBox.addItem(dep.getName());
    }
    depBox.addItem("δ���ò���");
    depBox.setPreferredSize(new Dimension(100,30));
    jpanel1.add(depBox);
    
    
    JButton searchBtn=new JButton();
    searchBtn.setPreferredSize(new Dimension(100,30));
    searchBtn.setText(Constant.MES_SEARCH);
    jpanel1.add(searchBtn);
    searchBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method empb
		//ÿ��һ�����ݶ������һ���ϴβ�����ݣ�����ڶ��β��ʱ����ֵ�һ�ε����ݡ�	
		    
		     
		     
			String name=nameText.getText();
			String sex=sexText.getText();//.toString();toString���ֿո��ʱ�򲻻�Ӱ���ѯ���
			int age=-1;
//			try{
//				//������
//				}catch(Exception e){
//				//�쳣����
//				}
//				����������д��󣬾ͻ᷵����д�쳣�Ĵ���
			
			
		try{
			age=Integer.parseInt(ageText.getText());
		}catch(Exception ex){
			age=-1;
			}
			
//			if (!ageText.getText().equals("")) {
//				age = Integer.parseInt(ageText.getText());
//			}

		Employee condition=new Employee();
		condition.setName(name);
		condition.setSex(sex);
		condition.setAge(age);
		
		int index=depBox.getSelectedIndex();
		Department dep=new Department();
		if(index>0){
		if(index<=depList.size()){
			dep=depList.get(index-1);
		}
		else{
			dep.setId(-1);
		}
		}
		condition.setDep(dep);
        list=empDao.searchByCondition(condition);
              refreshTable(list);

		}
		
	});
    	
    
//�м����
    model=new EmployeeTableModel(list);
    table=new JTable();
    table.setModel(model);
    //java�ṩ�����ⷽ������Ҫ��table���������Ҫʹ��EmployeeTableModel����
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
	//���������õĵ�����AddEmployee add=AddEmployee.getInstance()��������Ҳֻ��ʾһ��ҳ�档
	//����������һ���ڲ��࣬�ص��ķ��������б�ˢ�£����ô�ֵ�ˣ�������java�ĸ��ھۣ�����ϵ�ԭ��
			AddEmployeeView add=AddEmployeeView.getInstance();
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
			// TODO Auto-generated method empb
			
		//selectΪѡ�е���һ�С�
			//���޸ĵ�ʱ���Ȳ�һ��������
//			searchList=oai.searchAll();
		
			select=table.getSelectedRow();
			System.out.println(select);
			if(select!=-1){                                             //��searchListѡ����һ�е�ֵ 
				ModifyEmployeeView modify=ModifyEmployeeView.getInstance();
				//����new�Ķ��������������С�
				
				Employee emp=list.get(select);
				modify.createFrame(emp.getId(),table,new CallBack(){
  
					@Override
					public void call() {
						// TODO Auto-generated method empb
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
			// TODO Auto-generated method empb
			 select=table.getSelectedRow();
			 if(select!=-1){
				 int n = JOptionPane.showConfirmDialog(null, "С������ȷ��Ҫɾ��ô��", "����С����",JOptionPane.YES_NO_OPTION);//i=0/1
			
					 Employee emp=new Employee();
					 for(int i=0;i<list.size();i++){
						 emp=list.get(select); 
					 }
					 
					 
					 int rs=empDao.delete(emp);
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
		list=empDao.searchAll();
		model.setData(list);
		model.fireTableDataChanged();
	}
	public void refreshTable(List<Employee> list) {
		model.setData(list);
		model.fireTableDataChanged();
	}


}
