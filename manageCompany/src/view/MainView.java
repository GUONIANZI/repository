package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.Constant;
import view.department.DepartmentView;
import view.employee.EmployeeView;
import view.project.ProjectView;
import view.score.ScoreView;

public class MainView extends JFrame{
	public void init() {
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel mainPanel = (JPanel) this.getContentPane();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		JButton stuButton = new JButton("员工管理");
		stuButton.setPreferredSize(new Dimension(150, 80));
		stuButton.setFont(new Font(null, Font.BOLD, 25));
		
		JButton bjButton = new JButton("部门管理");
		bjButton.setPreferredSize(new Dimension(150, 80));
		bjButton.setFont(new Font(null, Font.BOLD, 25));

		JButton subButton = new JButton("项目管理");
		subButton.setPreferredSize(new Dimension(150, 80));
		subButton.setFont(new Font(null, Font.BOLD, 25));

		JButton scButton = new JButton("绩效管理");
		scButton.setPreferredSize(new Dimension(150, 80));
		scButton.setFont(new Font(null, Font.BOLD, 25));
		
		

		mainPanel.add(stuButton);
		mainPanel.add(bjButton);
		mainPanel.add(subButton);
		mainPanel.add(scButton);

		stuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				EmployeeView sv = EmployeeView.getInstance();
				sv.createFrame();

			}
		});
		
		bjButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DepartmentView bv = DepartmentView.getInstance();
				bv.createFrame();

			}
		});
		
		subButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			ProjectView sv=ProjectView.getInstance();
			sv.createFrame();
				
			}
		});
		
		scButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			   ScoreView sv=new ScoreView(); 
			   sv.init();
				
			}
		});
		
		this.setVisible(true);

	}
	

	public static void main(String[] args) {

		new MainView().init();
	}
	
}
