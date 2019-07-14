package sise.student.com;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ScoreInfomation extends JFrame{
	private JComboBox<String> gradeChoice;
	private JComboBox<String> classChoice;
	private JComboBox<String> courseChoice;
	static DefaultTableModel data;
	static JTable table;
	static ResultSet rs;
	static int i=0;
	static JTextField jt;
	static JPanel jPa;
	public ScoreInfomation() {
		super("�ɼ���Ϣ");
		Container con =getContentPane();
		JPanel infoJPanel =new JPanel(new FlowLayout());
		
		JLabel gradeJLabel =new JLabel("�꼶��ѯ");
		String []gradeInfo = {"   ","ȫ�꼶","��һ","����","����"};
		gradeChoice=new JComboBox<String>(gradeInfo);
		JLabel jLabel1 =new JLabel("                		     ");
		
		JLabel classJLabel =new JLabel("�༶��ѯ");
		String []classInfo = {"  ","һ��","����","����"};
		classChoice=new JComboBox<String>(classInfo);
		JLabel jLabel2 =new JLabel("                		     ");
		
		JLabel jLabel3 =new JLabel("                					     ");
		JButton submitButton =new JButton("�˳�");
		
		data=new DefaultTableModel();//���JTable
		table=new JTable(data);
		table.setEnabled(false);
		table.setRowHeight(30);
		
		JScrollPane allInfoJScrollPane =new JScrollPane(table);
		allInfoJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		allInfoJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		infoJPanel.add(gradeJLabel);
		infoJPanel.add(gradeChoice);
		infoJPanel.add(jLabel1);
		infoJPanel.add(classJLabel);
		infoJPanel.add(classChoice);
		infoJPanel.add(jLabel2);
		infoJPanel.add(submitButton);
		con.add(infoJPanel,"North");
		
		con.add(allInfoJScrollPane,"Center");
		
		
		
		setSize(800, 600);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
		
		
		
		//�鿴�꼶�ɼ�
		gradeChoice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String sname=(String) e.getItem();
				if (sname.equals("ȫ�꼶")) {
					ScoreInfoTable.tableMove(); 
					ScoreInfoTable.addScoreJTable(); //���table
					String sql="select * from tb_gradeinfo_sub";
					i=GetTotol.totol1(sql);
					GetTotol.setSum1(i);					
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							ScoreInfomation.data.addRow(ScoreInfoTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				else if(sname.equals("��һ")) {
					ScoreInfoTable.tableMove(); 
					ScoreInfoTable.addScoreJTable(); //���table
					String sql="select * from tb_gradeinfo_sub where grade = "+"'"+sname+"'";
					i=GetTotol.totol1(sql);
					GetTotol.setSum1(i);
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							ScoreInfomation.data.addRow(ScoreInfoTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if (sname.equals("����")) {
					ScoreInfoTable.tableMove(); 
					ScoreInfoTable.addScoreJTable(); //���table
					String sql="select * from tb_gradeinfo_sub where grade = "+"'"+sname+"'";
					i=GetTotol.totol1(sql);
					GetTotol.setSum1(i);
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							ScoreInfomation.data.addRow(ScoreInfoTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
				else if (sname.equals("����")) {
					ScoreInfoTable.tableMove(); 
					ScoreInfoTable.addScoreJTable(); //���table
					String sql="select * from tb_gradeinfo_sub where grade = "+"'"+sname+"'";
					i=GetTotol.totol1(sql);
					GetTotol.setSum1(i);
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							ScoreInfomation.data.addRow(ScoreInfoTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
			
		
	    //�鿴�༶�ɼ�	
		classChoice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String sClassname=(String) e.getItem();
				if(sClassname.equals("һ��")) {
					ScoreInfoTable.tableMove(); 
					ScoreInfoTable.addScoreJTable(); //���table
					String sql="select * from tb_gradeinfo_sub where sclass = "+"'"+sClassname+"'";
					i=GetTotol.totol1(sql);
					GetTotol.setSum1(i);
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							ScoreInfomation.data.addRow(ScoreInfoTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if (sClassname.equals("����")) {
					ScoreInfoTable.tableMove(); 
					ScoreInfoTable.addScoreJTable(); //���table
					String sql="select * from tb_gradeinfo_sub where sclass = "+"'"+sClassname+"'";
					i=GetTotol.totol1(sql);
					GetTotol.setSum1(i);
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							ScoreInfomation.data.addRow(ScoreInfoTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
				else if (sClassname.equals("����")) {
					ScoreInfoTable.tableMove(); 
					ScoreInfoTable.addScoreJTable(); //���table
					String sql="select * from tb_gradeinfo_sub where sclass = "+"'"+sClassname+"'";
					i=GetTotol.totol1(sql);
					GetTotol.setSum1(i);
					rs =DBHelper.select(sql);
					 int count=1;//����rs.first()�Ѿ��ڵ�һ��λ����,�������ѭ���ֵ�����next(),���Դ˴�count��1��ʼ  
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							ScoreInfomation.data.addRow(ScoreInfoTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),
									DBHelper.rs.getString("english"),DBHelper.rs.getString("politics"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("physics")));
						count++;
						}System.out.println(count);
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
			
		
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sname =e.getActionCommand();
				if(sname.equals("�˳�")) {
					dispose();
				}
				
			}
		});
		
		//��ȡ��������
		jPa=new JPanel();
		jt=new JTextField();                     
		jt.setText("�������ݡ�"+i+"����");
		jt.setEditable(false);
		jPa.add(jt);
		jPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.add(jPa,"South");
		
		
	}
//	public static void main(String[] args) {
//		ScoreInfomation sfm =new ScoreInfomation();
//	}
//	
}
