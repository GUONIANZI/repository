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

// 创建一个窗口
	public void init(){
	list=depDao.searchAll();
	
	frame.setSize(800,500);//frame的窗口得用setSize显示
	frame.setTitle("部门管理");
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
    
 //上层面板
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
    	
    
//中间面板
    model=new DepartmentTableModel(list);
    table=new JTable();
    table.setModel(model);
    //java提供的特殊方法，想要往table里面放数据要使用DepartmentTableModel方法
    JScrollPane scroll=new JScrollPane(table);
    scroll.setPreferredSize(new Dimension(600,300));
    jpanel2.add(scroll);
     
//下层面板
//增加-------------------------------------------------------------    
    JButton addBtn=new JButton();
    addBtn.setPreferredSize(new Dimension(70,30));
    addBtn.setText(Constant.MES_ADD);
    jpanel3.add(addBtn);
    addBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
	//创建对象用的单例。AddDepartment add=AddDepartment.getInstance()，点击多次也只显示一个页面。
	//里面又用了一个内部类，回调的方法，让列表刷新，不用传值了，保持了java的高内聚，低耦合的原则。
			AddDepartmentView add=AddDepartmentView.getInstance();
			add.createFrame(new CallBack(){
				@Override
		        
				public void call() {
					refreshTable();
				}
				
			});


			
		}
	});
 
 //修改------------------------------------------------------------------   
    JButton modifyBtn=new JButton();
    modifyBtn.setPreferredSize(new Dimension(70,30));
    modifyBtn.setText(Constant.MES_MODIFY);
    jpanel3.add(modifyBtn);
    modifyBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method depb
			
		//select为选中的那一行。
			//点修改的时候先查一下行数。
//			searchList=oai.searchAll();
		   
			int select=table.getSelectedRow();
			if(select!=-1){                                             //将searchList选的那一行的值 
				ModifyDepartmentView modify=ModifyDepartmentView.getInstance();
				//把新new的对象放在上面会攒行。
				
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
				JOptionPane.showMessageDialog(null, "请您先选中一行嘛~讨厌~ ");
			}
		}
	});
    
// 删除--------------------------------------------------------------   
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
				 int n = JOptionPane.showConfirmDialog(null, "小主，您确定要删除么？", "您的小宠物",JOptionPane.YES_NO_OPTION);//i=0/1
			
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
				 JOptionPane.showMessageDialog(null, "请您先选中一行嘛~讨厌~ ");
			 }
		}
	});
    
    JButton depBtn=new JButton();
    depBtn.setPreferredSize(new Dimension(110,30));
    depBtn.setText("部门管理");
    jpanel3.add(depBtn);
    depBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int select=table.getSelectedRow();
			if(select<0){
				JOptionPane.showMessageDialog(null, "请您先选中一行嘛~讨厌~ ");
				
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
