package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	public static String dbUrlString = "jdbc:mysql://localhost:3306/car_rental?useUnicode=true&characterEncoding=UTF-8";
	public static String dbUser = "root";
	public static String dbpassword = "root";
	public static String driver = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		
		try {						
			String url = "jdbc:mysql://localhost:3306/car_rental?useUnicode=true&characterEncoding=UTF-8";
			String user ="root";
			String password = "132714";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 用于关闭资源对象
	public static void close(Connection conn,Statement statement,ResultSet rs) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(statement!=null)
			try {
				statement.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
	}
	
	
}
