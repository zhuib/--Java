package sise.student.com;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sise.student.com.DBHelper;

class StudentBaseSystem extends JFrame{

JPanel manegetar,manegeblock,manegeLeft,manegeRight;
JLabel grandeLabel,classLabel,sidJLabel,sNameJLabel,sexJLabel,
		sAddressJLabel,sgradeLabel,sclassJLabel,sAgeLabel,sPhoneLabel;
JComboBox gradeChoice,classChoice,sexChoice;
JButton updateButton,addButton,deleteButton,saveButton,existButton;
JTextField sidField,sNameField,sAddressField,sgradeField,sclassField,sAgeField,sPhoneField;
String sid,sName,sSex,sAddr,sgrade,sclass,sAge,stel;
static DefaultTableModel data;
static JTable table;
Container con;
	public StudentBaseSystem() {
		super("ѧ��������Ϣ����");
		con =getContentPane();
		manegetar =new JPanel(new FlowLayout());
		grandeLabel = new JLabel("�����꼶:");
		String []grade= {"  ","��һ","����","����"};
		gradeChoice =new JComboBox<String>(grade);
		classLabel = new JLabel("�����༶:");
		String []classl = {"  ","һ��","����","����"};
		classChoice =new JComboBox<String>(classl);
		updateButton =new JButton("ˢ��");
		addButton =new JButton("���");
		deleteButton =new JButton("ɾ��");
		saveButton =new JButton("����");
		existButton =new JButton("�˳�");
		
		data=new DefaultTableModel();//���JTable
		table=new JTable(data);
//		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(30);
		JScrollPane p=new JScrollPane(table);
		//���ù�����
		p.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		con=getContentPane();
		con.add(p,"Center");
		
		manegeblock =new JPanel(new BorderLayout());
		manegeLeft =new JPanel(new GridLayout(4, 2));
		sidJLabel =new JLabel("ѧ�����");
		sidField =new JTextField(16);
		sNameJLabel =new JLabel("ѧ������");
		sNameField =new JTextField(16);
		sexJLabel =new JLabel("�Ա�");
		String []sex = {"��","Ů"};
		sexChoice=new JComboBox<String>(sex);
		sAddressJLabel =new JLabel("��ͥ��ַ");
		sAddressField =new JTextField(16);
		
		manegeRight =new JPanel(new GridLayout(4, 2));
		sgradeLabel =new JLabel("�꼶");
		sgradeField =new JTextField();
		sclassJLabel =new JLabel("�༶����");
		sclassField =new JTextField(16);
		sAgeLabel =new JLabel("����");
		sAgeField =new JTextField();
		sPhoneLabel =new JLabel("��ϵ�绰");
		sPhoneField =new JTextField(16);
		//==========================================================
		//����
		manegetar.add(grandeLabel);
		manegetar.add(gradeChoice);
		manegetar.add(classLabel);
		manegetar.add(classChoice);
		manegetar.add(updateButton);
		manegetar.add(addButton);
		manegetar.add(deleteButton);
		manegetar.add(saveButton);
		manegetar.add(existButton);
		con.add(manegetar,"North");
		
		//============================================================
		//����
		manegeLeft.add(sidJLabel);
		manegeLeft.add(sidField);
		manegeLeft.add(sNameJLabel);
		manegeLeft.add(sNameField);
		manegeLeft.add(sexJLabel);
		manegeLeft.add(sexChoice);
		manegeLeft.add(sAddressJLabel);
		manegeLeft.add(sAddressField);
		
		manegeRight.add(sgradeLabel);
		manegeRight.add(sgradeField);
		manegeRight.add(sclassJLabel);
		manegeRight.add(sclassField);
		manegeRight.add(sAgeLabel);
		manegeRight.add(sAgeField);
		manegeRight.add(sPhoneLabel);
		manegeRight.add(sPhoneField);
		//==============================================================
		//����
		manegeblock.add(manegeLeft,"West");
		manegeblock.add(manegeRight,"East");

		con.add(manegeblock,"South");
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		setFont(new Font("����",Font.PLAIN,28));
		//����������
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
		
		
		//�����꼶ɸѡ
		gradeChoice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String gradeString=(String) e.getItem();
				
				if(gradeString.equals("��һ")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //���table
					String sql="select * from tb_studentinfo where grade = "+"'"+gradeString+"'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if (gradeString.equals("����")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //���table
					String sql="select * from tb_studentinfo where grade = "+"'"+gradeString+"'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				else if (gradeString.equals("����")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //���table
					String sql="select * from tb_studentinfo where grade = "+"'"+gradeString+"'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
			
		
		//���а༶ɸѡ
		classChoice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String as =(String) gradeChoice.getSelectedItem();
				String gradeString=(String) e.getItem();
				System.out.println(as);
				
				//�꼶��ɸѡ�༶
				if(as.equals("��һ")) {
					System.out.println("ok");
				if(gradeString.equals("һ��")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //���table
					String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '��һ'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if (gradeString.equals("����")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //���table
					String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '��һ'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if (gradeString.equals("����")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //���table
					String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '��һ'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}}
				
				
				else if(as.equals("����")) {
					if(gradeString.equals("һ��")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //���table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '����'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if (gradeString.equals("����")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //���table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '����'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if (gradeString.equals("����")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //���table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '����'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}}
				
				else if(as.equals("����")) {
					if(gradeString.equals("һ��")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //���table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '����'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if (gradeString.equals("����")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //���table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '����'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if (gradeString.equals("����")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //���table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '����'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
				}}
			}
		});
		
		//��������
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddStudentJTable.tableMove();            //���table
				UpdataInfo.Alluser();
			}
		});
		
		//�������
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getAdd =e.getActionCommand();
				if(getAdd.equals("���")) {
					System.out.println("ok");
					sid=sidField.getText();
					sName=sNameField.getText();
					sSex=(String)sexChoice.getSelectedItem();
					sAddr=sAddressField.getText();
					sgrade=sgradeField.getText();
					sclass=sclassField.getText();
					sAge=sAgeField.getText();
					stel=sPhoneField.getText();
					String sql1 ="select * from tb_studentinfo where sid = "+"'"+sid+"'";
					ResultSet rs = DBHelper.select(sql1);
					if(sid.equals("")||sName.equals("")||sSex.equals("")||sAddr.equals("")||sgrade.equals("")||sclass.equals("")||sAge.equals("")||stel.equals("")) {
						JOptionPane.showMessageDialog(null,"����������д��Ϣ��");
					} else
						try {
							if(rs.next()==true) {
											JOptionPane.showMessageDialog(null,"����Ϣ�Ѵ��ڣ�");
											
										}

								else if(rs.next()==false){
								String sql=	"insert into tb_studentinfo (sid,grade,sclass,sname,gender,age,address,phone)" +"values" 
										+"("+"'"+sid+"'"+","+"'"+sgrade+"'"+","+"'"+sclass+"'"+","+"'"+sName+"'"+","+"'"+sSex+"'"+","+"'"+sAge+"'"+","+"'"+sAddr+"'"+","+"'"+stel+"'"+")";
										System.out.println(sql);
										int i =DBHelper.update(sql);
										if(i==0) {
											JOptionPane.showMessageDialog(null,"���ʧ�ܣ�������д�ı���Ƿ�Ϊ���֣�");
										}
										else{JOptionPane.showMessageDialog(null,"��ӳɹ���");}
							}
						} catch (HeadlessException | SQLException e1) {
							e1.printStackTrace();
						}
				}
			}
		});
		
		//ɾ������
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getdelete =e.getActionCommand();
				if(getdelete.equals("ɾ��")) {
					
					int row=table.getSelectedRow();
					//�ж��Ƿ�ѡ��
					if(row==-1) {
						JOptionPane.showMessageDialog(null,"��ѡ����Ҫɾ�������ݣ�");
						System.out.println(row);
					}
					//����ѡȡ
					else {int row1=table.getSelectedRow();
					System.out.println(row1);
//					String msg=;
					if(JOptionPane.showConfirmDialog(null, "Delect '"+data.getValueAt(row1, 0)+"'?","��ʾ",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)
							==JOptionPane.YES_OPTION) {
						
						String sql="delete from tb_studentinfo where sid='"+data.getValueAt(row1,0)+"';";
						System.out.println(data.getValueAt(row1,0));
						System.out.println(sql);
						if (DBHelper.update(sql)==1) {
							JOptionPane.showMessageDialog(null,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
							data.removeRow(row1);
						}else {
							JOptionPane.showMessageDialog(null,"ɾ��ʧ��","��ʾ",JOptionPane.ERROR_MESSAGE);
						}
					}
					}
				}
			}
		});
		//���̼���
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getSave =e.getActionCommand();
				if(getSave.equals("����")) {
					SaveFile.setstudent();
//					JOptionPane.showMessageDialog(null,"����ɹ���");
				}
			}
		});
		
		//�˳�����
		existButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getexist =e.getActionCommand();
				if(getexist.equals("�˳�")) {
					dispose();
				}
			}
		});
		
		
		
		
	}
	
//	public static void main(String []args) {
//		StudentBaseSystem sbS =new StudentBaseSystem(); 
//}
}