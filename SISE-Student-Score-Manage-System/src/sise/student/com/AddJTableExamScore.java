package sise.student.com;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddJTableExamScore {
	static JScrollPane p;
	public static void addJTable() {   //��ӱ�ͷ
		GradeSet.data.addColumn("ѧ�����");
		GradeSet.data.addColumn("ѧ������");
		GradeSet.data.addColumn("�꼶");
		GradeSet.data.addColumn("�༶");
		GradeSet.data.addColumn("��ѧ");
		GradeSet.data.addColumn("����");
		GradeSet.data.addColumn("Ӣ��");
		GradeSet.data.addColumn("��ѧ");
		GradeSet.data.addColumn("����");
		GradeSet.data.addColumn("����");
		
		
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"ѧ�����","ѧ������","�꼶","�༶","��ѧ","����","Ӣ��","��ѧ","����","����"});
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String sid,String sname,String grade,String sclass,String math,String chinese,String english,String chemistry,String politics,String physics){
		Object row[]=new Object[10];
		row[0]=sid;
		row[1]=sname;
		row[2]=grade;
		row[3]=sclass;
		row[4]=math;
		row[5]=chinese;
		row[6]=english;
		row[7]=chemistry;
		row[8]=politics;
		row[9]=physics;
		return row;
	}
	public static void tableMove() {//������
		GradeSet.data=(DefaultTableModel) GradeSet.table.getModel();
		GradeSet.data.setRowCount(0);// ���ԭ����
		GradeSet.data.setColumnCount(0);//����ԭ����
	}
}
