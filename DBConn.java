package com.lykion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	private static Connection conn;
	
	/**
	 * 连接数据库
	 * @return 
	 */
	public static Connection getConnection() {
		try {
			Class.forName(Contants.driver);		//加载mysql驱动
			System.out.println(Contants.driver + "加载成功！");
		} catch (ClassNotFoundException e) {
			System.out.println(Contants.driver + "加载失败(╯﹏╰)b");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(Contants.url, Contants.username, Contants.password);		//连接数据库
			System.out.println(Contants.url + "连接成功！");
		} catch (SQLException e) {
			System.out.println(Contants.url + "连接失败(╯﹏╰)b");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		if(conn != null) {
			conn.close();		//关闭数据库
		}
	}
}
