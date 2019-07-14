package sise.student.com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.*;

public class ExamCourseSet extends JFrame {
	static DefaultTableModel data;
	static JTable table;
	static JTextField gidField,gNameField;
	static String sql;
	public ExamCourseSet() {
		super("���Կ�Ŀ");
		Container con =getContentPane();
		
		data=new DefaultTableModel() {
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};//���JTable
		table=new JTable(data);
//		table.setEnabled(false);
		table.setPreferredScrollableViewportSize(new Dimension(500,300));
		table.setFont(new Font("����",Font.CENTER_BASELINE,15));
		Dimension size =table.getTableHeader().getPreferredSize();
		size.height=42;
		table.getTableHeader().setPreferredSize(size);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionForeground(Color.WHITE);
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);//��������
	
		
		
		JScrollPane p1=new JScrollPane(table);
		p1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		con=getContentPane();
		con.add(p1,"Center");
		
		JPanel JPanel =new JPanel(new GridLayout(2,2));
		JLabel gidJLabel =new JLabel("��Ŀ���");
		gidJLabel.setFont(new Font("����",Font.CENTER_BASELINE,20));
		gidField =new JTextField(20);
		JLabel gNameJLabel =new JLabel("��Ŀ����");
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
		
		AddCourseTable.tableCourseMove(); 
		AddCourseTable.addCourseTable();
		String sqlString ="select * from tb_subject";
		DBHelper.select(sqlString);				
		try {
			while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
				ExamCourseSet.data.addRow(AddCourseTable.datarow(DBHelper.rs.getString("cid"),DBHelper.rs.getString("course")));
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
						String sql="delete from tb_subject where cid='"+data.getValueAt(row,0)+"';";
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
		
		
		
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cid=gidField.getText();
				String course=gNameField.getText();
				
				String sql1 ="select * from tb_subject where cid = "+"'"+cid+"'";
				ResultSet rs = DBHelper.select(sql1);
				if(gidField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"����������д��Ϣ��");
				}else if(gNameField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"����������д��Ϣ��");
				}
				else
				 try {
					if(rs.next()==true) {
						JOptionPane.showMessageDialog(null,"����Ϣ�Ѵ��ڣ�");
						
					}
					

					else if(rs.next()==false){
					AddCourseTable.tableCourseMove();   //���table
					AddCourseTable.addCourseTable();  //��ӱ�ͷ
				sql="insert into tb_subject (cid,course)" +"values"+"("+"'"+cid+"'"+","+"'"+course+"'"+")";
				System.out.println(sql);
				DBHelper.update(sql);
				String sqlString ="select * from tb_subject";
				DBHelper.select(sqlString);				
				
					while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
						ExamCourseSet.data.addRow(AddCourseTable.datarow(DBHelper.rs.getString("cid"),DBHelper.rs.getString("course")));
					}
				}}
				
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
					SaveFile.setcourse();
//					JOptionPane.showMessageDialog(null,"����ɹ���");
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
//		ExamCourseSet gms =new ExamCourseSet();
//	}

}
