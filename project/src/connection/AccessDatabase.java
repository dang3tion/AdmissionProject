package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessDatabase {
	public static AccessDatabase c = new AccessDatabase();

	private AccessDatabase() {

	}

	public static AccessDatabase getInstance() {
		if (c == null) {
			c = new AccessDatabase();
		}
		return c;
	}

	public ResultSet executeQuery(String query, Object... parameters) {
		ResultSet resultSet = null;
		Connection con = null;
		try {
			con = SinglePool.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			int i = 0;
			for (Object object : parameters) {
				if (object instanceof String) {
					stmt.setString(i + 1, (String) object);
				}
				if (object instanceof Integer) {
					stmt.setInt(i + 1, (Integer) object);
				}
				if (object instanceof Double) {
					stmt.setDouble(i + 1, (Double) object);
				}
				i++;

			}
			if (query.toLowerCase().contains("select")) {
				resultSet = stmt.executeQuery();
			} else {
				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			SinglePool.returnConnection(con);
		}
		return resultSet;
	}

	/**
	 * @implNote CHá»ˆ DÃ™NG TRONG TRÆ¯á»œNG Há»¢P DANH SÃ�CH THAM Sá»� Ä�á»€U LÃ€
	 *           STRING
	 * @param query : cÃ¢u truy váº¥n khÃ´ng chá»©a tham sá»‘ (String)
	 * @return : tráº£ vá»� 1 ResultSet, null Ä‘á»‘i vá»›i cÃ¢u lá»‡nh delete
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet updateQuery(String query) {
		ResultSet resultSet = null;
		Connection con = null;
		try {
			con = SinglePool.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			if (query.toLowerCase().contains("select")) {
				resultSet = stmt.executeQuery();
			} else {
				stmt.executeUpdate();
			}
			SinglePool.returnConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SinglePool.returnConnection(con);
		}
		return resultSet;
	}
}
