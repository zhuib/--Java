package sise.student.com;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddJTabelUserQuery {
	static JScrollPane p;
	public static void addJTable() {   //��ӱ�ͷ
		SumOfInformation.data.addColumn("���");
		SumOfInformation.data.addColumn("�û�����");
		SumOfInformation.data.addColumn("����");
		SumOfInformation.data.addColumn("�ֻ�����");
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(int uid,String username,String pwd,String phone){
		Object row[]=new Object[7];
		row[0]=uid;
		row[1]=username;
		row[2]=pwd;
		row[3]=phone;
		return row;
	}
	public static void tableMove() {//������
		SumOfInformation.data=(DefaultTableModel) SumOfInformation.table.getModel();
		SumOfInformation.data.setRowCount(0);// ���ԭ����
		SumOfInformation.data.setColumnCount(0);//����ԭ����
	}
}
