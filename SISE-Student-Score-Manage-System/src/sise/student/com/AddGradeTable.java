package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddGradeTable {
	static JScrollPane p;
	public static void addGradeTable() {   //��ӱ�ͷ
		GradeManageSet.data.addColumn("�꼶���");
		GradeManageSet.data.addColumn("�꼶����");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"�꼶���","�꼶����"});
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String gid,String grade){
		Object row[]=new Object[2];
		row[0]=gid;
		row[1]=grade;
		
		return row;
	}
	public static void tableMove() {//������
		GradeManageSet.data=(DefaultTableModel) GradeManageSet.table.getModel();
		GradeManageSet.data.setRowCount(0);// ���ԭ����
		GradeManageSet.data.setColumnCount(0);//����ԭ����
	}
	
	
	public static Object[] dataClassrow(String gid,String grade){
		Object row[]=new Object[2];
		row[0]=gid;
		row[1]=grade;
		
		return row;
	}
	public static void tableClassMove() {//������
		GradeManageSet.data=(DefaultTableModel) GradeManageSet.table.getModel();
		GradeManageSet.data.setRowCount(0);// ���ԭ����
		GradeManageSet.data.setColumnCount(0);//����ԭ����
	}
}

