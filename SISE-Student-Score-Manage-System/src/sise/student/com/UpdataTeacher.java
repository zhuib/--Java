package sise.student.com;

import java.sql.SQLException;

import javax.swing.JFrame;
//ˢ�½�ʦ��Ϣ
public class UpdataTeacher extends JFrame{
	static String sql=null;
	public static void Alluser(){
		AddTeacherJTable.addJTable();  //��ӱ�ͷ
		sql="select * from tb_teacher";
		DBHelper.select(sql);
		try {
			while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
				TeacherBaseSystem.data.addRow(AddTeacherJTable.datarow(DBHelper.rs.getString("tid"),DBHelper.rs.getString("tgrade"),DBHelper.rs.getString("tclass"),DBHelper.rs.getString("tname"),DBHelper.rs.getString("gender"),
						DBHelper.rs.getString("course"),DBHelper.rs.getString("phone")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
