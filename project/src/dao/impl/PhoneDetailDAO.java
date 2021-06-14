package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.AccessDatabase;
import dao.IPhoneDetailDAO;
import model.PhoneDetail;

public class PhoneDetailDAO implements IPhoneDetailDAO {
	private static PhoneDetailDAO ins = new PhoneDetailDAO();

	public PhoneDetailDAO() {

	}

	public static PhoneDetailDAO getInstance() {
		if (ins == null) {
			ins = new PhoneDetailDAO();
		}
		return ins;
	}

	@Override
	public boolean insertPhone(PhoneDetail phone,String id) {
		AccessDatabase ac = AccessDatabase.getInstance();
		String query = "INSERT INTO SDT VALUES(?,?,?,?,'1')";
		try (ResultSet rs = ac.executeQuery(query,phone.getTitle(),phone.getPhoneNo(),phone.getState(), id)) {
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
