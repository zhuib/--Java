package sise.student.com;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class ScoreManageSystem  extends JFrame{
//private java.awt.Image image;
	ScoreManageSystem(){
		//���ò˵���
		super("ѧ���ɼ�����ϵͳ");
		MenuBar menubar=new MenuBar ();
		Menu fatorMenu=new Menu("���������á�");
		Menu baseManageMenu=new Menu("��������Ϣ��");
		Menu systemSelectMenu=new Menu("��ϵͳ��ѯ��");
		Menu systemManage=new Menu("��ϵͳ����");
		
		MenuItem gradeSet=new MenuItem("�꼶����");
		MenuItem classSet=new MenuItem("�༶����");
		MenuItem exaMenuItem=new MenuItem("���Կ�Ŀ");
		MenuItem examKindItem=new MenuItem("�������");
		
		MenuItem studentInfo=new MenuItem("ѧ����Ϣ");
		MenuItem teacherInfo=new MenuItem("��ʦ��Ϣ");
		MenuItem examScore=new MenuItem("���Գɼ�");
		
		MenuItem baseInfo=new MenuItem("������Ϣ");
		MenuItem ScoreInfo=new MenuItem("�ɼ���Ϣ");
		MenuItem sumInfo=new MenuItem("������Ϣ");
		
		MenuItem userPair=new MenuItem("�û�ά��");
		MenuItem existSys=new MenuItem("�˳�ϵͳ");
		
		
		fatorMenu.add(gradeSet);
		fatorMenu.add(classSet);
		fatorMenu.add(exaMenuItem);
		fatorMenu.add(examKindItem);
		baseManageMenu.add(studentInfo);
		baseManageMenu.add(teacherInfo);
		baseManageMenu.add(examScore);
		systemSelectMenu.add(baseInfo);
		systemSelectMenu.add(ScoreInfo);
		systemSelectMenu.add(sumInfo);
		systemManage.add(userPair);
		systemManage.add(existSys);
		menubar.add(fatorMenu);
		menubar.add(baseManageMenu);
		menubar.add(systemSelectMenu);
		menubar.add(systemManage);
		setMenuBar(menubar);
		menubar.setFont(new Font("����",Font.PLAIN,15));
		
		JPanel panel =new JPanel(new BorderLayout());
		JPanel panel1 =new JPanel(new BorderLayout());
		JPanel panelBar =new JPanel(new FlowLayout(FlowLayout.LEFT));
		//���ͼƬ
		ImageIcon iiIcon26 =new ImageIcon("src\\Picture\\26.jpg");
		JLabel paint1 =new JLabel(iiIcon26);
		ImageIcon iiIcon27 =new ImageIcon("src\\Picture\\27.jpg");
		JLabel paint2 =new JLabel(iiIcon27);
		ImageIcon iiIcon28 =new ImageIcon("src\\Picture\\28.jpg");
		JLabel paint3 =new JLabel(iiIcon28);
		ImageIcon iiIcon29 =new ImageIcon("src\\Picture\\29.jpg");
		JLabel paint4 =new JLabel(iiIcon29);
		ImageIcon iiIcon0000 =new ImageIcon("src\\Picture\\0000.jpg");
		final JLabel paint5 =new JLabel(iiIcon0000);
		ImageIcon iiIcon00 =new ImageIcon("src\\Picture\\000.jpg");
		JLabel paint6 =new JLabel(iiIcon00);
		panelBar.add(paint1);
		panelBar.add(paint2);
		panelBar.add(paint3);
		panelBar.add(paint4);
		panelBar.add(paint5);
		panelBar.add(paint6);
		panel.add(panelBar,"North");
		panel.add(panel1,"West");
		add(panel,"North");
	    //�������ǰ��ɫ�ͱ���ɫ
		panel.setBackground(Color.RED);
		panel.setForeground(Color.GREEN);
		
		ImageIcon iiIcon =new ImageIcon("src\\Picture\\3.jpg");
		JLabel label =new JLabel(iiIcon);
		label.setSize(900,700);
		this.add(label,"South");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,700);
		setBackground(Color.GREEN);
		setForeground(Color.GREEN);
		setVisible(true);
		setFont(new Font("����",Font.PLAIN,15));
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
		
		//ͼ�����������
		
		paint1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new StudentBaseSystem();
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint4.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "�ù��ܿ�����.....��");	
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint6.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new Picture();
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new TeacherBaseSystem();
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new ScoreInfomation() ;
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint5.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			int i = JOptionPane.showConfirmDialog(null,"ȷ���˳�ϵͳ��","��ʾ",JOptionPane.YES_NO_OPTION);
				 if(i==0){//��==0����ִ��else
					    System.exit(0);
					 }
					 else;
				
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		//�û�ά��
		userPair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�ù��ܿ�����.....��");				}});
		//�ɼ���Ϣ
		ScoreInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ScoreInfomation() ;
				}
			
		});
		//������Ϣ
		 sumInfo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new SumOfInformation();
					}
				
			});
		 //���Գɼ�
		examScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GradeSet();
				}
			
		});
		//��������
		examKindItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new sise.student.com.ExamKindSet();
				}
			
		});
		//�γ���Ϣ
		exaMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ExamCourseSet();
				}
			
		});
		//�༶��Ϣ
		classSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ClassManageSet();
				}
			
		});
		//�꼶��Ϣ
		gradeSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GradeManageSet();
				}
			
		});
		//��ʦ��Ϣ
		teacherInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TeacherBaseSystem();
				}
			
		});
		//ѧ����Ϣ
		studentInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StudentBaseSystem();
				}
			
		});
		//������Ϣ��ѯ
		baseInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Query1();
				}
			
		});
		//�˳����水ť
		 existSys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"ȷ���˳�ϵͳ��","��ʾ",JOptionPane.YES_NO_OPTION);
				 if(i==0){//��==0����ִ��else
					 System.exit(0);
				 }
				 else;
			}
			
		});
	}
	
//	public static void main(String[] args) {
//	ScoreManageSystem s=new ScoreManageSystem();
//	// Yonghudenglu y=new  Yonghudenglu();
//	//GradeSet g=new GradeSet();
//	}

}
