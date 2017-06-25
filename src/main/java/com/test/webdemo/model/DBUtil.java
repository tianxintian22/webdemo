package com.test.webdemo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicoding=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	public static Connection conn;
	
	static {
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//通过数据库的连接操作数据库，实现增删改查
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		//获得数据库的连接
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//通过数据库的连接操作数据库，实现增删改查
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select user_name, age from test_users");
			
			while (rs.next()) {
				System.out.println(rs.getString("user_name") + "," + rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
