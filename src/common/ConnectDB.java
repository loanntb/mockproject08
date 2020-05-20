
package common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class ConnectDB {
	private static String DB_URL = "jdbc:jtds:sqlserver://iphone:1433/QUANLYNHANVIEN;integratedSecurity=false";
			
	private static String USER_NAME = "sa";
	private static String PASSWORD = "123";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}
