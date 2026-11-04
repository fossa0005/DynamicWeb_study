package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBUtil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	private final String url = "jdbc:mysql://localhost:3306/BoardPRJ?serverTimezone=UTC";
	private final String user = "ssafy";
	private final String password = "ssafy";
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw e;
		}
		return conn;
		//세현아 에러뜨잖아. 틀렸어. 아아아아아아아아아아아 이세현 바보 아아아아아아아아
	}
}

