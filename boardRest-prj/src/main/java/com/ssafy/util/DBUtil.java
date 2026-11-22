package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBUtil {
	 private final String url =
	            "jdbc:mysql://localhost:3306/BoardPRJ?serverTimezone=Asia/Seoul";
	    private final String user = "ssafy";
	    private final String password = "ssafy";

	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	    }

	    public void close(AutoCloseable... closeables) {
	        for (AutoCloseable closeable : closeables) {
	            if (closeable != null) {
	                try {
	                    closeable.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }
}
