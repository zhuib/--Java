package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddTeacherJTable {
	static JScrollPane p;
	public static void addJTable() {   //��ӱ�ͷ
		TeacherBaseSystem.data.addColumn("��ʦ���");
		TeacherBaseSystem.data.addColumn("�����꼶");
		TeacherBaseSystem.data.addColumn("���̰༶");
		TeacherBaseSystem.data.addColumn("��ʦ����");
		TeacherBaseSystem.data.addColumn("�Ա�");
		TeacherBaseSystem.data.addColumn("���̿γ�");
		TeacherBaseSystem.data.addColumn("��ϵ�绰");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"��ʦ���","�����꼶","���̰༶","��ʦ����","�Ա�","���̿γ�","��ϵ�绰"});

	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String tid,String tgrade,String tclass,String tname,String gender,String course,String phone){
		Object row[]=new Object[7];
		row[0]=tid;
		row[1]=tgrade;
		row[2]=tclass;
		row[3]=tname;
		row[4]=gender;
		row[5]=course;
		row[6]=phone;
		return row;
	}
	public static void tableMove() {//������
		TeacherBaseSystem.data=(DefaultTableModel) TeacherBaseSystem.table.getModel();
		TeacherBaseSystem.data.setRowCount(0);// ���ԭ����
		TeacherBaseSystem.data.setColumnCount(0);//����ԭ����
	}
}
