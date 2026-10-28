package com.ssafy.prj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private final String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
	private final String user = "ssafy";
	private final String password = "ssafy";
	
	//초기화 블록으로 드라이버 로드(최초1회)
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public void close(AutoCloseable... closeables) {
		//AutoCloseable 인터페이스
		//구현체 : FileReader, BufferedReader, Connection, Statement....
		//해당 인터페이스의 구현체를 개수 상관없이(...) 받아서 내부에서 배열(closeables)로 사용
		for(AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}

