package com.demo.org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	
	//静态代码块，在类加载时执行
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取数据库连接
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost/java0102s7?user=root&password=demo";
		return DriverManager.getConnection(url);
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try{
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
