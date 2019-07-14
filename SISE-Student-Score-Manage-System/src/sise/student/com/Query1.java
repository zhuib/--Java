package sise.student.com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Query1 extends JFrame {

	String str1,str2,sql;
	private JComboBox<String> seculateChoice;
	private JComboBox<String> selectKindChoice;
	private JComboBox<String> charatarChoice;
	static JTable table;
	static DefaultTableModel data;
	static int i=0;
	static JPanel jPa;
	static JTextField jt;
	Query1(){
		Container con =getContentPane();
		//���ñ߽粼�ֹ�����
	    setLayout(new BorderLayout());
	    
	    //���p1   ��ѯ���͡��ֶΡ����������ֵ�ȵ�
	    JPanel panel1=new JPanel();
		JLabel QueryType=new JLabel("��ѯ����");
		
		String []selectKind = {"    ","ѧ����Ϣ","��ʦ��Ϣ","���Գɼ�"};
		selectKindChoice=new JComboBox<String>(selectKind);
		panel1.add(QueryType);
		panel1.add(selectKindChoice);		
		
		JLabel Field1=new JLabel("�ֶ�");
		String []charatar = {"    ","ѧ�����","��ʦ���"};
		charatarChoice=new JComboBox<String>(charatar);
		panel1.add(Field1);
		panel1.add(charatarChoice);	
		
		JLabel Operate1=new JLabel("�����");
		String []seculate = {"like"};
		seculateChoice=new JComboBox<String>(seculate);
		panel1.add(Operate1);
		panel1.add(seculateChoice);	
		
		JLabel Num=new JLabel("��ֵ");
		JTextField textNum=new JTextField(10);
		panel1.add(Num);
		panel1.add(textNum);	
		//��ť
		JButton bt1=new JButton("ȷ��");
		JButton bt2=new JButton("�˳�");        
		panel1.add(bt1);
		panel1.add(bt2);
		
		
		
		//======================================================================
		//p2���ݿ��б�
		

		data=new DefaultTableModel();//���JTable
		table=new JTable(data);
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        table.setRowHeight(30);
        JScrollPane scrollPane1 = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(900, 700));
        
        con.add(scrollPane1,"Center");

		
		selectKindChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String gradeString=(String) e.getItem();
				if(gradeString.equals("ѧ����Ϣ")) {
					QueryBaseInfo.tableMove(); 
					QueryBaseInfo.addStudentJTable(); 
					sql="select * from tb_studentinfo";
					i=GetTotol.totol(sql);
					GetTotol.setSum(i);
					DBHelper.select(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				
				}
				else if(gradeString.equals("��ʦ��Ϣ")) {
					QueryBaseInfo.tableMove();
					QueryBaseInfo.addJTable();//���table
					sql="select * from tb_teacher";
					i=GetTotol.totol(sql);
					GetTotol.setSum(i);
					DBHelper.select(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
									DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
					}
				else if(gradeString.equals("���Գɼ�")) {
					QueryBaseInfo.tableMove();
					QueryBaseInfo.addScoreJTable();
					sql="select * from tb_gradeinfo_sub";
					i=GetTotol.totol(sql);
					GetTotol.setSum(i);
					DBHelper.select(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
					}
//			
		}
	});
	
		
		//ȷ����ť���¼�����======================================
		bt1.addActionListener(new ActionListener() {//����Ų�ѯ�����û������¼�
			public void actionPerformed(ActionEvent e) {
				String s =e.getActionCommand();
				System.out.println("ok");
				QueryBaseInfo.tableMove();
				if(s.equals("ȷ��")) {
					String aS=(String)charatarChoice.getSelectedItem();
					System.out.println(aS);
					String sum= textNum.getText();
					if(aS.equals("��ʦ���")) {
						QueryBaseInfo.tableMove();
						QueryBaseInfo.addJTable();//���table
						sql="select * from tb_teacher where tid ="+"'"+sum+"'";
						i=GetTotol.totol(sql);
						GetTotol.setSum(i);
						DBHelper.select(sql);
						try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
								Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
										DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if(aS.equals("ѧ�����")) {
						QueryBaseInfo.tableMove(); 
						QueryBaseInfo.addStudentJTable(); 
						sql="select * from tb_studentinfo where sid ="+"'"+sum+"'";
						i=GetTotol.totol(sql);
						GetTotol.setSum(i);
						DBHelper.select(sql);
						try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
								Query1.data.addRow(QueryBaseInfo.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					
					}
				}
				
			}
		});

		//�˳���ť���¼�����
		bt2.addActionListener(new ActionListener(){
	    	
			public void actionPerformed(ActionEvent e) {
				//�˳�ʱ��ѯ�ʣ������Ի���
				int i = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���","��ʾ",JOptionPane.YES_NO_OPTION);
				 if(i==0){//��==0����ִ��else
				    dispose();
				 }
				 else;
			}
			});
		
		
				i =GetTotol.setSum(i);
				System.out.println(i);
		//p3     �������ݣ���
				jPa=new JPanel() ;
				jt=new JTextField();                     
				jt.setText("�������ݡ�"+i+"����");
				jt.setEditable(false);
				jPa.add(jt);
				jPa.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				//��岼��
				add("North",panel1);
				add("South",jPa);
				setTitle("������Ϣ���ݲ�ѯ");
				pack();
				
				setSize(800, 600);
//				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
				setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2);
	
			
	}
	
	
	public void actionPerformed(ActionEvent e) {}
	
	
//	public static void main(String[] args) {
//	    Query1 query=new Query1();	
////	    SelectSingleOne Single=new SelectSingleOne();
//	}

}
