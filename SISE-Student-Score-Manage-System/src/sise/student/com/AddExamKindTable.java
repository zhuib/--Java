package sise.student.com;


import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddExamKindTable {
	static JScrollPane p;
	public static void addGradeTable() {   //��ӱ�ͷ
		ExamKindSet.data.addColumn("��Ŀ");
		ExamKindSet.data.addColumn("��������");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"��Ŀ","��������"});
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String exam,String check){
		Object row[]=new Object[2];
		row[0]=exam;
		row[1]=check;
		
		return row;
	}
	public static void tableMove() {//������
		ExamKindSet.data=(DefaultTableModel) ExamKindSet.table.getModel();
		ExamKindSet.data.setRowCount(0);// ���ԭ����
		ExamKindSet.data.setColumnCount(0);//����ԭ����
	}
}

