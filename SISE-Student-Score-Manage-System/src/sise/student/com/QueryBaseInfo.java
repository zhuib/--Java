package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class QueryBaseInfo {
	static JScrollPane p;
	public static void addJTable() {   //��ӱ�ͷ
		Query1.data.addColumn("��ʦ���");
		Query1.data.addColumn("�����꼶");
		Query1.data.addColumn("���̰༶");
		Query1.data.addColumn("��ʦ����");
		Query1.data.addColumn("�Ա�");
		Query1.data.addColumn("���̿γ�");
		Query1.data.addColumn("��ϵ�绰");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"��ʦ���","�����꼶","���̰༶","��ʦ����","�Ա�","���̿γ�","��ϵ�绰"});

	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String tid,String tgrade,String tclass,String tname,String gender,String course,String phone){
		Object row[]=new Object[7];//"id","grade1","sname","gender","age","address","phone"
		row[0]=tid;
		row[1]=tgrade;
		row[2]=tclass;
		row[3]=tname;
		row[4]=gender;
		row[5]=course;
		row[6]=phone;
		return row;
	}

	
	
//	static JScrollPane p;
	public static void addStudentJTable() {   //��ӱ�ͷ
		Query1.data.addColumn("ѧ�����");
		Query1.data.addColumn("�꼶");
		Query1.data.addColumn("�༶����");
		Query1.data.addColumn("ѧ������");
		Query1.data.addColumn("�Ա�");
		Query1.data.addColumn("����");
		Query1.data.addColumn("��ͥ��ַ");
		Query1.data.addColumn("��ϵ�绰");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"ѧ�����","�꼶","�༶����","ѧ������","�Ա�","����","��ͥ��ַ","��ϵ�绰"});
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String sid,String grade,String sclass,String sname,String gender,String age,String address,String phone){
		Object row[]=new Object[8];
		row[0]=sid;
		row[1]=grade;
		row[2]=sclass;
		row[3]=sname;
		row[4]=gender;
		row[5]=age;
		row[6]=address;
		row[7]=phone;
		return row;
	}

	
	public static void addScoreJTable() {   //��ӱ�ͷ
		Query1.data.addColumn("ѧ�����");
		Query1.data.addColumn("�꼶");
		Query1.data.addColumn("�༶");
		Query1.data.addColumn("ѧ������");
		Query1.data.addColumn("��ѧ�ɼ�");
		Query1.data.addColumn("���ĳɼ�");
		Query1.data.addColumn("Ӣ��ɼ�");
		Query1.data.addColumn("���γɼ�");
		Query1.data.addColumn("��ѧ�ɼ�");
		Query1.data.addColumn("����ɼ�");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"ѧ�����","�꼶","�༶","ѧ������","��ѧ�ɼ�","���ĳɼ�","Ӣ��ɼ�","���γɼ�","��ѧ�ɼ�","����ɼ�"});
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String sid,String grade,String sclass,String sname,String math,String chinese,String english,String politics,String chemistry,String physics){
		Object row[]=new Object[10];
		row[0]=sid;
		row[1]=grade;
		row[2]=sclass;
		row[3]=sname;
		row[4]=math;
		row[5]=chinese;
		row[6]=english;
		row[7]=politics;
		row[8]=chemistry;
		row[9]=physics;
		return row;
	}
	
	public static void tableMove() {//������
		Query1.data=(DefaultTableModel) Query1.table.getModel();
		Query1.data.setRowCount(0);// ���ԭ����
		Query1.data.setColumnCount(0);//����ԭ����
	}
}


