package sise.student.com;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreInfoTable {
	static JScrollPane p;
	public static void addScoreJTable() {   //��ӱ�ͷ
		ScoreInfomation.data.addColumn("ѧ�����");
		ScoreInfomation.data.addColumn("�꼶");
		ScoreInfomation.data.addColumn("�༶");
		ScoreInfomation.data.addColumn("ѧ������");
		ScoreInfomation.data.addColumn("��ѧ�ɼ�");
		ScoreInfomation.data.addColumn("���ĳɼ�");
		ScoreInfomation.data.addColumn("Ӣ��ɼ�");
		ScoreInfomation.data.addColumn("���γɼ�");
		ScoreInfomation.data.addColumn("��ѧ�ɼ�");
		ScoreInfomation.data.addColumn("����ɼ�");
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"ѧ�����","�꼶","�༶","ѧ������","��ѧ�ɼ�","���ĳɼ�","Ӣ��ɼ�","���γɼ�","��ѧ�ɼ�","����ɼ�"});
	}
	//��������������Ŵ����ݿ�ȡ��������
	public static Object[] datarow(String sid,String grade,String sclass,String sname,String math,String chinese,String english,String politics,String chemistry,String physics){
		Object row[]=new Object[10];
		row[0]=sid;
		row[1]=grade;
		row[2]=sclass;
		row[3]=sname;
		row[4]=math;
		row[5]=chinese;
		row[6]=english;
		row[7]=politics;
		row[8]=chemistry;
		row[9]=physics;
		return row;
	}
	
	public static void tableMove() {//������
		ScoreInfomation.data=(DefaultTableModel) ScoreInfomation.table.getModel();
		ScoreInfomation.data.setRowCount(0);// ���ԭ����
		ScoreInfomation.data.setColumnCount(0);//����ԭ����
	}
	

}
