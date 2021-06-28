package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connection.AccessDatabase;
import dao.ICollegesDAO;
import mapper.RowMapper;
import model.CollegesInfo;

public class CollegesDAO implements ICollegesDAO {
	private static CollegesDAO instance = new CollegesDAO();

	public static CollegesDAO getInstance() {
		return instance;
	}

	private CollegesDAO() {
	}

	@Override
	public boolean isIdExists(String id) {
		AccessDatabase ac = AccessDatabase.getInstance();
		String query = "SELECT * FROM TRUONGHOC WHERE MATRUONG=?";
		try (ResultSet rs = ac.executeQuery(query, id)) {
			if (!rs.isBeforeFirst()) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public int getIdColleges(String idColleges) {
		AccessDatabase ac = AccessDatabase.getInstance();
		String query = "SELECT ID_TRUONG FROM TRUONGHOC WHERE MATRUONG=?";
		try (ResultSet rs = ac.executeQuery(query, idColleges)) {
			if (rs.next()) {
				return Integer.parseInt(rs.getString("ID_TRUONG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

	public boolean insertColleges(CollegesInfo c) {
		AccessDatabase ac = AccessDatabase.getInstance();
		String query = "INSERT INTO TRUONGHOC VALUES(?,?,?,?,?,?,?,'1')";
		try (ResultSet rs = ac.executeQuery(query, c.getIdColleges(), c.getState(), c.getName(), c.getType(),
				c.getWebsite(), c.getIntroduce(), c.getAdmissionDetail())) {
			// address
			int id = getIdColleges(c.getIdColleges());
			System.out.println("idturong" + id);
			for (int i = 0; i < c.getListAdress().size(); i++) {
				AddressDAO.getInstance().insertAddress(c.getListAdress().get(i), id + "");
			}
			// phone
			for (int i = 0; i < c.getListPhone().size(); i++) {
				PhoneDetailDAO.getInstance().insertPhone(c.getListPhone().get(i), id + "");
			}
			// img
			for (int i = 0; i < c.getLstImg().size(); i++) {
				ImageDAO.getInstance().insertImage(c.getLstImg().get(i), id + "");
			}

			// frame
			for (int i = 0; i < c.getListFrame().size(); i++) {
				FrameDAO.getInstance().insertFrame(c.getListFrame().get(i), id + "");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void main(String[] args) {
	}

	@Override
	public List<CollegesInfo> searchColleges(String search, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
