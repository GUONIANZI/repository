package view.department;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import util.Constant;
import view.ShowMessage;
import dao.ManageProject2DepartmentDao;
import entity.Department;
import entity.Project;



public class ManageProject2DepartmentView {

	List<Project> list ;
	List<Project> notList;
	ManageProject2DepartmentModel model;
	JTextField nameText;
	JTextField subNumsText;
	ManageProject2DepartmentDao manageDao= new ManageProject2DepartmentDao();
	JTable table ;

 
	private Department bj;
	JComboBox addBox;
	
	
	public ManageProject2DepartmentView(Department bj) {
		this.bj=bj;
		
	}

	
	
	// ����һ������
	public void init() {
	
		JFrame frame=new JFrame();
		frame.setSize(600, 400);// frame�Ĵ��ڵ���setSize��ʾ
		frame.setTitle("��Ŀ����");
		frame.setLocationRelativeTo(null);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout box = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(box);

		JPanel jpanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 20));
		JPanel jpanel2 = new JPanel();
		JPanel jpanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		mainPanel.add(jpanel1);
		mainPanel.add(jpanel2);
		mainPanel.add(jpanel3);
		

		// �ϲ����
		JLabel nameLable = new JLabel();
		nameLable.setText(bj.getName());
		nameLable.setFont(new Font(null, Font.BOLD, 20));
		nameLable.setPreferredSize(new Dimension(200, 30));
		jpanel1.add(nameLable);
		

		// �м����
        list=manageDao.searchByDepId(bj.getId());
		model = new ManageProject2DepartmentModel(list);
		table = new JTable(model);
		// java�ṩ�����ⷽ������Ҫ��table���������Ҫʹ��SubjectTableModel����
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(400, 150));
		jpanel2.add(scroll);

		// �²����
		// ���ӿ�Ŀ-------------------------------------------------------------

		addBox = new JComboBox();
		refreshAddBox();
		addBox.setPreferredSize(new Dimension(100, 30));
		jpanel3.add(addBox);

		JButton addBtn = new JButton();
		addBtn.setPreferredSize(new Dimension(70, 30));
		addBtn.setText(Constant.MES_ADD);
		jpanel3.add(addBtn);
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = addBox.getSelectedIndex();
				int subId = notList.get(index).getId();

				boolean rs = manageDao.add(bj.getId(), subId);
				ShowMessage.show(rs, Constant.MES_ADD);
				refreshTable();
				refreshAddBox();
				JOptionPane.showMessageDialog(null, "С�������ѱ���ɹ�~ ");

			}
		});

		// ɾ����Ŀ--------------------------------------------------------------
		JButton deleateBtn = new JButton();
		deleateBtn.setPreferredSize(new Dimension(70, 30));
		deleateBtn.setText(Constant.MES_DELETE);
		JPanel jpanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
		
		jpanel3.add(jpanel4);
		jpanel4.add(deleateBtn);
		deleateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method bjb
				int select = table.getSelectedRow();
				if (select != -1) {
					int type = JOptionPane.showConfirmDialog(null, "С������ȷ��Ҫɾ��ô��",
							"����С����", JOptionPane.YES_NO_OPTION);// i=0/1
				if(type==0){
					boolean flag=manageDao.delete(bj.getId(),list.get(select).getId());
					ShowMessage.show(flag, Constant.MES_DELETE);
					refreshTable();
				}

				} else {
					JOptionPane.showMessageDialog(null, "������ѡ��һ����~����~ ");
				}
			}
		});

		 frame.setVisible(true);

	}

	public void refreshTable() {

		list = manageDao.searchByDepId(bj.getId());
		model.setData(list);
		model.fireTableDataChanged();
		
	}
	
	public void refreshAddBox() {
		notList = manageDao.searchByNotDepId(bj.getId());
		addBox.removeAllItems();
		for (int i = 0; i < notList.size(); i++) {
			addBox.addItem(notList.get(i).getName());
		}
	}

}
