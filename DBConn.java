package com.lykion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	private static Connection conn;
	
	/**
	 * �������ݿ�
	 * @return 
	 */
	public static Connection getConnection() {
		try {
			Class.forName(Contants.driver);		//����mysql����
			System.out.println(Contants.driver + "���سɹ���");
		} catch (ClassNotFoundException e) {
			System.out.println(Contants.driver + "����ʧ��(�s�n�t)b");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(Contants.url, Contants.username, Contants.password);		//�������ݿ�
			System.out.println(Contants.url + "���ӳɹ���");
		} catch (SQLException e) {
			System.out.println(Contants.url + "����ʧ��(�s�n�t)b");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ر����ݿ�����
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		if(conn != null) {
			conn.close();		//�ر����ݿ�
		}
	}
}
