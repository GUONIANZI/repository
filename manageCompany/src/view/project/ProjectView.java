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

// 创建一个窗口
	public void init(){
	list=proDao.searchAll();
	frame.setSize(800,500);//frame的窗口得用setSize显示
	frame.setTitle("项目管理");
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
			// TODO Auto-generated method prob
		//每点一次数据都会清空一次上次查的数据，避免第二次查的时候出现第一次的数据。	
		    
		     
		     
			String name=nameText.getText();
			
//			try{
//				//代码区
//				}catch(Exception e){
//				//异常处理
//				}
//				代码区如果有错误，就会返回所写异常的处理。
			
			
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
    	
    
//中间面板
    model=new ProjectTableModel(list);
    table=new JTable();
    table.setModel(model);
    //java提供的特殊方法，想要往table里面放数据要使用ProjectTableModel方法
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
	//创建对象用的单例。AddProject add=AddProject.getInstance()，点击多次也只显示一个页面。
	//里面又用了一个内部类，回调的方法，让列表刷新，不用传值了，保持了java的高内聚，低耦合的原则。
			AddProjectView add=AddProjectView.getInstance();
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
			// TODO Auto-generated method bjb
			
		//select为选中的那一行。
			//点修改的时候先查一下行数。
//			searchList=oai.searchAll();
		
			select=table.getSelectedRow();
			if(select!=-1){                                             //将searchList选的那一行的值 
				ModifyProjectView modify=ModifyProjectView.getInstance();
				//把新new的对象放在上面会攒行。
				
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
			// TODO Auto-generated method bjb
			 select=table.getSelectedRow();
			 if(select!=-1){
				 int n = JOptionPane.showConfirmDialog(null, "小主，您确定要删除么？", "您的小宠物",JOptionPane.YES_NO_OPTION);//i=0/1
			
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
				 JOptionPane.showMessageDialog(null, "请您先选中一行嘛~讨厌~ ");
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
