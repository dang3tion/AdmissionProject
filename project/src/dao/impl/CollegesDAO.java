package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.AccessDatabase;
import connection.SinglePool;
import dao.ICollegesDAO;
import mapper.CollegesMapper;
import model.CollegesInfo;
import page.Page;

public class CollegesDAO extends AbstractDAO<CollegesInfo> implements ICollegesDAO {
	private static CollegesDAO instance = new CollegesDAO();

	public static CollegesDAO getInstance() {
		return instance;
	}

	private CollegesDAO() {
	}

	@Override
	public int doInsert(CollegesInfo t, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean doUpdate(CollegesInfo t, Object... params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(int id, Object... params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CollegesInfo doGet(int id, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollegesInfo> searchColleges(String search, Page page, Object... params) {
		String sql = "SELECT * FROM TRUONGHOC th ";
		sql += "JOIN DIACHI dc ON th.ID_TRUONG = dc.ID_TRUONG ";
		sql += "JOIN KHUNGDT_TRUONG kt ON th.ID_TRUONG = kt.ID_TRUONG ";
		sql += "JOIN NGANH_TOHOP nt ON nt.ID_KDT = kt.ID_KDT ";
		sql += "JOIN NGANH n ON n.ID_NGANH = nt.ID_NGANH ";
		sql += "WHERE th.TENTRUONG LIKE '%" + search + "%' ";
		// filter condition
		if (params.length > 0) {
			sql += "AND dc.TINH LIKE ? AND n.TEN_NGANH LIKE ? AND th.LOAITRUONG LIKE ?";
		}
		//
		sql += " ORDER BY @@CURSOR_ROWS OFFSET " + page.getOffset() + " ROWS FETCH NEXT " + page.getMaxPageItem()
				+ " ROWS ONLY";
		return query(sql, new CollegesMapper(), params);
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

}
