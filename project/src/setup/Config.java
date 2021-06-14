package setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import connection.SinglePool;

public class Config {
	public static int DB_MAX_CONNECTIONS = 10;
	public static String SERVER_NAME = "jdbc:sqlserver://localhost:1433";
	public static String DATABASE_NAME = "TT_TUYENSINH_2";
	public static String USERNAME_DB = "sa";
	public static String PASSWORD_DB = "123456";
	public static String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static void main(String[] args) {
		String URL = Config.SERVER_NAME + ";databaseName=" + Config.DATABASE_NAME;
		Connection connection = null;
		try {
			Class.forName(Config.DBDRIVER);
			connection = DriverManager.getConnection(URL, Config.USERNAME_DB, Config.PASSWORD_DB);
			System.out.println(connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
