package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddCourseTable {
	static JScrollPane p;
	public static void addCourseTable() {   //��ӱ�ͷ
		ExamCourseSet.data.addColumn("��Ŀ���");
		ExamCourseSet.data.addColumn("��Ŀ����");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"��Ŀ���","��Ŀ����"});
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String cid,String course){
		Object row[]=new Object[2];
		row[0]=cid;
		row[1]=course;
		
		return row;
	}
	public static void tableMove() {//������
		ExamCourseSet.data=(DefaultTableModel) ExamCourseSet.table.getModel();
		ExamCourseSet.data.setRowCount(0);// ���ԭ����
		ExamCourseSet.data.setColumnCount(0);//����ԭ����
	}
	
	
	public static Object[] dataCourserow(String cid,String course){
		Object row[]=new Object[2];
		row[0]=cid;
		row[1]=course;
		
		return row;
	}
	public static void tableCourseMove() {//������
		ExamCourseSet.data=(DefaultTableModel) ExamCourseSet.table.getModel();
		ExamCourseSet.data.setRowCount(0);// ���ԭ����
		ExamCourseSet.data.setColumnCount(0);//����ԭ����
	}
}

