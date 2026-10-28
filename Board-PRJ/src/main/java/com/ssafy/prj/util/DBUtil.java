package com.ssafy.prj.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
		
	private final String url = "jdbc:mysql:localhost:3306/ssafydb?serverTimezone=UTC";
	private final String user = "ssafy";
	private final String password = "ssafy";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}

