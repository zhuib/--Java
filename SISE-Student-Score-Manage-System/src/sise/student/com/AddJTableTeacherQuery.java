package sise.student.com;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddJTableTeacherQuery {
	static JScrollPane p;
	public static void addJTable() {   //��ӱ�ͷ
		SumOfInformation.data.addColumn("���");
		SumOfInformation.data.addColumn("��ʦ����");
		SumOfInformation.data.addColumn("�Ա�");
		SumOfInformation.data.addColumn("�γ�");
		SumOfInformation.data.addColumn("�ֻ�����");
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(int tid,String tname,String gender,String course,String phone){
		Object row[]=new Object[7];
		row[0]=tid;
		row[1]=tname;
		row[2]=gender;
		row[3]=course;
		row[4]=phone;
		return row;
	}
	public static void tableMove() {//������
		SumOfInformation.data=(DefaultTableModel) SumOfInformation.table.getModel();
		SumOfInformation.data.setRowCount(0);// ���ԭ����
		SumOfInformation.data.setColumnCount(0);//����ԭ����
	}
}
