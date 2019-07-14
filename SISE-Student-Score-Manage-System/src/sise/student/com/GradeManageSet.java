package sise.student.com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.*;

public class GradeManageSet extends JFrame {
	static DefaultTableModel data;
	static JTable table;
	static JTextField gidField,gNameField;
	static String sql;
	private Component contain;
	String gid;
	public GradeManageSet() {
		super("�꼶��Ϣ����");
		Container con =getContentPane();
		
        //���JTable
		table=new JTable(data);
//		table.setEnabled(false);
		table.setPreferredScrollableViewportSize(new Dimension(500,300));
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);//��������
		
		JScrollPane p1=new JScrollPane(table);
		p1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		con=getContentPane();
		con.add(p1,"Center");
		
		
		JPanel JPanel =new JPanel(new GridLayout(2,2));
		JLabel gidJLabel =new JLabel("�꼶���");
		gidJLabel.setFont(new Font("����",Font.CENTER_BASELINE,20));
		gidField =new JTextField(20);
		JLabel gNameJLabel =new JLabel("�꼶����");
		gNameJLabel.setFont(new Font("����",Font.CENTER_BASELINE,20));
		gNameField =new JTextField(20);
		
		JPanel butJPanel =new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton dropButton =new JButton("ɾ��");
		JButton addButton =new JButton("���");
		JButton saveButton =new JButton("����");
		JButton existButton =new JButton("�˳�");
		
		con.add(p1,"North");
		
		JPanel.add(gidJLabel);
		JPanel.add(gidField);
		JPanel.add(gNameJLabel);
		JPanel.add(gNameField);
		con.add(JPanel,"Center");
		
		butJPanel.add(dropButton);
		butJPanel.add(addButton);
		butJPanel.add(saveButton);
		butJPanel.add(existButton);
		con.add(butJPanel,"South");
		
		AddGradeTable.tableMove(); 
		AddGradeTable.addGradeTable();
		String sqlString ="select * from tb_gradeinfo";
		DBHelper.select(sqlString);				
		try {
			while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
				GradeManageSet.data.addRow(AddGradeTable.datarow(DBHelper.rs.getString("gid"),DBHelper.rs.getString("grade")));
			}
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		setSize(600, 520);
		setFont(new Font("����",Font.PLAIN,15));
		setForeground(Color.black);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
		
		//���������ɾ��
		
		
		dropButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object getDrop =e.getSource();
				if(getDrop==dropButton) {
					int row=table.getSelectedRow();
					//�ж��Ƿ�ѡ��
					if(row==-1) {
						JOptionPane.showMessageDialog(null,"��ѡ����Ҫɾ�������ݣ�");
						System.out.println(row);
					}
					//����ѡȡ
					else {int row1=table.getSelectedRow();
					String msg="Delect '"+data.getValueAt(row, 0)+"'?";
					if (JOptionPane.showConfirmDialog(null, msg,"��ʾ",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)
							==JOptionPane.YES_OPTION) {
						String sql="delete from tb_gradeinfo where gid='"+data.getValueAt(row,0)+"';";
						System.out.println(data.getValueAt(row,0));
						System.out.println(sql);
						if (DBHelper.update(sql)==1) {
							JOptionPane.showMessageDialog(null,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
							data.removeRow(row);
						}else {
							JOptionPane.showMessageDialog(null,"ɾ��ʧ��","��ʾ",JOptionPane.ERROR_MESSAGE);
						}
					}
					}
				}
			}
		});
		
	//=====================================================================================	
		addButton.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				
				
				gid=gidField.getText();
				String grade=gNameField.getText();
				AddGradeTable.tableMove();            //���table
				AddGradeTable.addGradeTable();  
				
			
				
				if(gidField.getText().equals("")) {
					
					AddGradeTable.tableMove();            //���table
					AddGradeTable.addGradeTable(); 
					JOptionPane.showMessageDialog(null,"����������д��Ϣ��");
					
					String sqlString ="select * from tb_gradeinfo";
					DBHelper.select(sqlString);				
						try {
					while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							GradeManageSet.data.addRow(AddGradeTable.datarow(DBHelper.rs.getString("gid"),DBHelper.rs.getString("grade")));
						}}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
					}
				
				
					
					else if (gNameField.getText().equals("")) {

					AddGradeTable.tableMove();            //���table
					AddGradeTable.addGradeTable(); 
					JOptionPane.showMessageDialog(null,"����������д��Ϣ��");
					
					String sqlString ="select * from tb_gradeinfo";
					DBHelper.select(sqlString);				
						try {
					while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							GradeManageSet.data.addRow(AddGradeTable.datarow(DBHelper.rs.getString("gid"),DBHelper.rs.getString("grade")));
						}}
					catch(SQLException e1) {
						e1.printStackTrace();
					}

				}
			   else
					try {	
						String sql1 ="select * from tb_gradeinfo where gid = "+"'"+gid+"'";
					ResultSet rs = DBHelper.select(sql1);

						if(rs.next()==true) {
							JOptionPane.showMessageDialog(null,"����Ϣ�Ѵ��ڣ�");
							AddGradeTable.tableMove();            //���table
							AddGradeTable.addGradeTable(); 
							
							String sqlString ="select * from tb_gradeinfo";
							DBHelper.select(sqlString);				
								try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
									GradeManageSet.data.addRow(AddGradeTable.datarow(DBHelper.rs.getString("gid"),DBHelper.rs.getString("grade")));
								}}
							catch(SQLException e1) {
								e1.printStackTrace();
							}

						}
						

				else if(rs.next()==false){
				
				
				AddGradeTable.tableMove();            //���table
				AddGradeTable.addGradeTable();  //��ӱ�ͷ
				sql="insert into tb_gradeinfo (gid,grade)" +"values"+"("+"'"+gid+"'"+","+"'"+grade+"'"+")";
				System.out.println(sql);
				DBHelper.update(sql);
				String sqlString ="select * from tb_gradeinfo";
				DBHelper.select(sqlString);				


					while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
						GradeManageSet.data.addRow(AddGradeTable.datarow(DBHelper.rs.getString("gid"),DBHelper.rs.getString("grade")));
					}}}
				
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object getSave =e.getSource();
				if(getSave==saveButton) {
					SaveFile.set();
				}
			}
		});
		
		existButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object getExist =e.getSource();
				if(getExist==existButton) {
					dispose();
				}
			}
		});
	}
	
	
//	public static void main(String[] args) {
//		GradeManageSet gms =new GradeManageSet();
//	}

}
