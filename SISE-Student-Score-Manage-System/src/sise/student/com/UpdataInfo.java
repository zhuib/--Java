package sise.student.com;

import java.sql.SQLException;

import javax.swing.JFrame;
//ˢ��ѧ����Ϣ
public class UpdataInfo extends JFrame{
	static String sql=null;
	public static void Alluser(){
		AddStudentJTable.addJTable();  //��ӱ�ͷ
		sql="select * from tb_studentinfo";
		DBHelper.select(sql);
		try {
			while(DBHelper.rs.next()) {  //�����ݷ���datarow�����к�ӵ�data����
				StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
						DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
