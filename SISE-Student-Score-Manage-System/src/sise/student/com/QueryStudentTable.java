package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class QueryStudentTable {
	static JScrollPane p;
	public static void addJTable() {   //��ӱ�ͷ
		StudentBaseSystem.data.addColumn("ѧ�����");
		StudentBaseSystem.data.addColumn("�꼶");
		StudentBaseSystem.data.addColumn("�༶����");
		StudentBaseSystem.data.addColumn("ѧ������");
		StudentBaseSystem.data.addColumn("�Ա�");
		StudentBaseSystem.data.addColumn("����");
		StudentBaseSystem.data.addColumn("��ͥ��ַ");
		StudentBaseSystem.data.addColumn("��ϵ�绰");
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
	public static void tableMove() {//������
		StudentBaseSystem.data=(DefaultTableModel) StudentBaseSystem.table.getModel();
		StudentBaseSystem.data.setRowCount(0);// ���ԭ����
		StudentBaseSystem.data.setColumnCount(0);//����ԭ����
	}
}
