package sise.student.com;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddClassTable {
	static JScrollPane p;
	public static void addClassTable() {   //��ӱ�ͷ
		ClassManageSet.data.addColumn("�༶���");
		ClassManageSet.data.addColumn("�༶����");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"�༶���","�༶����"});
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String cid,String sclass){
		Object row[]=new Object[2];
		row[0]=cid;
		row[1]=sclass;
		
		return row;
	}
	public static void tableMove() {//������
		ClassManageSet.data=(DefaultTableModel) ClassManageSet.table.getModel();
		ClassManageSet.data.setRowCount(0);// ���ԭ����
		ClassManageSet.data.setColumnCount(0);//����ԭ����
	}
}

