package connection;

import java.sql.Connection;

public class SinglePool {
	public static int countOnlineUserQuantity = 0;

	// POOL Này dùng cho toàn web size
	private static final ConnectionPool pool = new ConnectionPool();

	public static Connection getConnection() {
		Connection connection = pool.getConnection();
		return connection;
	}

	public static void returnConnection(Connection connection) {
		pool.returnConnection(connection);
	}
}
