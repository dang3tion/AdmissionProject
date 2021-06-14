package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

import setup.Config;

public class ConnectionPool {
	// danh sÃ¡ch cÃ¡c single connection Ä�ANG TRá»�NG trong má»™t connection Pool
	private static Queue<Connection> availableConnections = new LinkedList<Connection>();

	public ConnectionPool() {
		while (!isMaxPool()) {
			availableConnections.add(createConnection());
		}
	}

	private synchronized boolean isMaxPool() {
		final int MAX_POOL_SIZE = Config.DB_MAX_CONNECTIONS;
		if (availableConnections.size() < MAX_POOL_SIZE) {
			return false;
		}
		return true;
	}

	// Táº¡o má»›i 1 single connection
	private Connection createConnection() {
		String URL = Config.SERVER_NAME + ";databaseName=" + Config.DATABASE_NAME;
		Connection connection = null;
		try {
			Class.forName(Config.DBDRIVER);
			connection = DriverManager.getConnection(URL, Config.USERNAME_DB, Config.PASSWORD_DB);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Thá»±c hiá»‡n cÃ¢u truy váº¥n SQL báº±ng connection nÃ y ( láº¥y ra tá»« list
	// connection )
	public synchronized Connection getConnection() {
		Connection connection = null;
		System.out.println(availableConnections.size());
		if (availableConnections.size() > 0) {
			connection = availableConnections.poll();
		}
		return connection;
	}

	// HoÃ n tráº£ single Connection vá»� Pool sau khi sá»­ dá»¥ng xong ( list avail
	// tÄƒng lÃªn
	// 1 ).
	public synchronized void returnConnection(Connection connection) {
		if (connection != null) {
			availableConnections.add(connection);
		}
	}
}
