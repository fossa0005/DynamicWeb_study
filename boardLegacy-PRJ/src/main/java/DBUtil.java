
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	private DBUtil() {}
	private static DBUtil dbUtil;
	public static synchronized DBUtil getDBUtil() {
		if (dbUtil == null) {
			dbUtil = new DBUtil();
		}
		return dbUtil;
	}
	
	private final String url = "jdbc:mysql:localhost:3306/ssafydb?serverTimezone=UTC";
	private final String user = "ssafy";
	private final String password = "ssafy";
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

