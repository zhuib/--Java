package sise.student.com;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTotol {
	
	private static ResultSet rs;
	static int count=0;
	
	//��ѯ�����ݵ�������������Ϣ��ѯ
	public static int totol(String sql) {
		System.out.println(sql);
		rs =DBHelper.select(sql);
		try {
			while(rs.next()) {
				count++;
			}
			Query1.jt.setText("�������ݡ�"+count+"����");
			count=0;
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static int setSum(int i) {
//		System.out.println(i);
		return i;
		
	}
	
	//��ѯ�����ݵ��������ɼ���ѯ
	public static int totol1(String sql) {
		System.out.println(sql);
		rs =DBHelper.select(sql);
		try {
			while(rs.next()) {
				count++;
			}

			ScoreInfomation.jt.setText("�������ݡ�"+count+"����");
			count=0;
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static int setSum1(int i) {
//		System.out.println(i);
		return i;
		
	}
	
}
