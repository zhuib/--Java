package sise.student.com;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddJTable1 {
	static JScrollPane p;
	public static void addJTable() {   //��ӱ�ͷ
		SumOfInformation.data.addColumn("���");
		SumOfInformation.data.addColumn("�༶����");
		SumOfInformation.data.addColumn("ѧ������");
		SumOfInformation.data.addColumn("�Ա�");
		SumOfInformation.data.addColumn("����");
		SumOfInformation.data.addColumn("��ַ");
		SumOfInformation.data.addColumn("�ֻ�����");
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(int sid,String grade,String sname,String gender,int age,String address,String tel){
		Object row[]=new Object[7];
		row[0]=sid;
		row[1]=grade;
		row[2]=sname;
		row[3]=gender;
		row[4]=age;
		row[5]=address;
		row[6]=tel;
		return row;
	}
	public static void tableMove() {//������
		SumOfInformation.data=(DefaultTableModel) SumOfInformation.table.getModel();
		SumOfInformation.data.setRowCount(0);// ���ԭ����
		SumOfInformation.data.setColumnCount(0);//����ԭ����
	}
}
