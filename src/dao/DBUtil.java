package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBUtil {
	private static PreparedStatement parment = null;//Ԥ�������
	private static ResultSet set = null;//�����
	static Connection conn;//���ݿ�����
	
	//��ȡ���ݿ�����
	public static Connection getConnection() {

		String url = ("jdbc:mysql://localhost:3306/flowershop?useSSL=false");
		String user = "root";
		String password = "120788";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.printf("��ȡ���ݿ�����ʧ�ܣ�����·�������ƣ�");
			e.printStackTrace();
		}
		return conn;
	}
	//�ر����ݿ�����
	public static void close() {
		try {
			if (!conn.isClosed()) {
					set.close();
					set = null;
					parment.close();
					parment = null;
					conn.close();
			}
		} catch (SQLException e) {
			System.out.printf("���ݿ����ӹر�ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
}
