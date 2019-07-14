package sise.student.com;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBHelper implements DBConfig {
	static Connection conn = null;
	static Statement stat = null;
	static ResultSet rs = null;

	//���Ӽ�������
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn =DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
		}
		
	
	//ִ�����ݿ����
	public static Statement openStatement() {
		try {
			stat=getConnect().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stat;
		}
	
	//��������
	public static int update(String str) {
		int count =0;
		try {
			count = openStatement().executeUpdate(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	//��ѯ����
	public static ResultSet select(String str) {
		
			try {
				rs =openStatement().executeQuery(str);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		
		return rs;
	}
	//�ر�����
	public static void closer() {
		try {
			if(rs!=null) 
			rs.close();
			if(stat!=null)
			stat.close();
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
}
