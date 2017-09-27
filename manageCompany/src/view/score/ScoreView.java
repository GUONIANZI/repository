package view.score;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import util.Constant;
import view.ShowMessage;
import dao.DepartmentDao;
import dao.ManageProject2DepartmentDao;
import dao.ScoreDao;
import dao.ProjectDao;
import entity.Department;
import entity.Score;
import entity.Employee;
import entity.Project;

public class ScoreView {
	JComboBox proBox;
	JComboBox depBox;
	List<Score> scList;


	List<Project> proList;
	List<Department> depList;
	ScoreTableModel model;
	JTable table;
	int select;
	JTextField nameText;
	JTextField scText;
	ScoreDao scDao=new ScoreDao();
	DepartmentDao depDao=new DepartmentDao();
	ProjectDao proDao=new ProjectDao();
  
	Set<Score> saveSet = new HashSet<Score>();

	ManageProject2DepartmentDao msbDao = new ManageProject2DepartmentDao();
// ´´½¨Ò»¸ö´°¿Ú
	public void init(){
	
	JFrame frame=new JFrame();
	frame.setSize(800,500);
	frame.setTitle("¼¨Ð§¹ÜÀí");
	frame.setLocationRelativeTo(null);

	
	JPanel mainPanel=(JPanel)frame.getContentPane();
    BoxLayout box=new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(box);
    
    JPanel jpanel1=new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
    JPanel jpanel2=new JPanel();
    JPanel jpanel3=new JPanel(new FlowLayout(FlowLayout.CENTER,100,20));
    mainPanel.add(jpanel1);
    mainPanel.add(jpanel2);
    mainPanel.add(jpanel3);
    

    JLabel nameLable=new JLabel();
    nameLable.setText("ÐÕÃû");
    jpanel1.add(nameLable);
    nameText=new JTextField();
    nameText.setPreferredSize(new Dimension(100,30));
    jpanel1.add(nameText);
    
    JLabel depLable=new JLabel();
    depLable.setText("²¿ÃÅ");
    jpanel1.add(depLable);
    depBox=new JComboBox();
    depBox.addItem("ÇëÑ¡Ôñ²¿ÃÅ");
    depList=depDao.searchAll();
    for(int i=0;i<depList.size();i++){
    	depBox.addItem(depList.get(i).getName());
    }
    depBox.setPreferredSize(new Dimension(100,30));
    jpanel1.add(depBox);
//    ¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª
    depBox.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			int index = -1;
			if (depBox.getSelectedIndex() > 0) {
				index = depBox.getSelectedIndex() - 1;
				proList = msbDao.searchByDepId(depList.get(index).getId());
			} else {

				proList = proDao.searchAll();

			}
			refreshProBox(proList);

		}
	});
//    ¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª
    JLabel proLable=new JLabel();
    proLable.setText("ÏîÄ¿");
    jpanel1.add(proLable);
    proBox=new JComboBox();
    proBox.addItem("ÇëÑ¡ÔñÏîÄ¿");
    proList=proDao.searchAll();
	refreshProBox(proList);

//    for(int i=0;i<proList.size();i++){
//    	proBox.addItem(proList.get(i).getName());
//    }
    proBox.setPreferredSize(new Dimension(100,30));
    jpanel1.add(proBox);

    
    
    
    JButton searchBtn=new JButton();
    searchBtn.setPreferredSize(new Dimension(100,30));
    searchBtn.setText(Constant.MES_SEARCH);
    jpanel1.add(searchBtn);
    searchBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String name=nameText.getText();
			Employee emp=new Employee();
			emp.setName(name);
			
			int index=depBox.getSelectedIndex();
//			System.out.println(index);
			Department dep=new Department();
			if(index>0){
			if(index<=depList.size()){
				dep=depList.get(index-1);
			}
			
			}else{
				dep.setId(-1);
			}
			
			index=proBox.getSelectedIndex();
			Project pro=new Project();
			if(index>0){
			if(index<=proList.size()){
				pro=proList.get(index-1);
			}
			
			}
			else{
				pro.setId(-1);
			}
			
			int score=-1;
		    try{
		    	score=Integer.parseInt(scText.getText());
		    }catch(Exception ex){
		    	score=-1;
			}
			

			Score condition=new Score();
			emp.setDep(dep);
			condition.setEmp(emp);
			condition.setPro(pro);
			condition.setScore(score);
			
	        scList=scDao.searchByCondition(condition);
	        refreshTable(scList);


	
		
	

		}
		
	});
    	
    
    
//ÖÐ¼äÃæ°å
    scList=scDao.searchAll();

	model=new ScoreTableModel(scList, saveSet);
    table=new JTable();
    table.setModel(model);
    JScrollPane scroll=new JScrollPane(table);
    scroll.setPreferredSize(new Dimension(600,300));
    jpanel2.add(scroll);
     
//ÏÂ²ãÃæ°å
//±£´æ-------------------------------------------------------------    
    JButton saveBtn=new JButton();
    saveBtn.setPreferredSize(new Dimension(70,30));
    saveBtn.setText("±£´æ");
    jpanel3.add(saveBtn);
    saveBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			boolean flag = scDao.save(saveSet);
			// saveList.clear();
			saveSet.clear();
			ShowMessage.show(flag, Constant.MES_SAVE);
			refreshTable();
		}

	});

	frame.setVisible(true);
	
	}
	private void refreshProBox(List<Project> proList) {
		proBox.removeAllItems();
		proBox.addItem("ÇëÑ¡ÔñÏîÄ¿~");
		for (Project pro : proList) {
		proBox.addItem(pro.getName());
		}

	}

	public void refreshTable(){
		
		scList=scDao.searchAll();
		model.setData(scList);
		model.fireTableDataChanged();
	}
	public void refreshTable(List<Score> list) {
		model.setData(list);
		model.fireTableDataChanged();
	}


}
