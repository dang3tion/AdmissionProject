package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.AccessDatabase;
import dao.IAddressDAO;
import model.AddressDetail;

public class AddressDAO implements IAddressDAO {
	private static AddressDAO ins = new AddressDAO();

	public AddressDAO() {

	}

	public static AddressDAO getInstance() {
		if (ins == null) {
			ins = new AddressDAO();
		}
		return ins;
	}

	@Override
	public boolean insertAddress(AddressDetail address, String id) {
		AccessDatabase ac = AccessDatabase.getInstance();
		String query = "INSERT INTO DIACHI VALUES(?,?,?,?,?,?,?,'1')";
		try (ResultSet rs = ac.executeQuery(query, address.getTitle(), address.getAddress(), address.getAddress(),
				address.getCity(), address.getDistrict(), address.getState(), id)) {
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
