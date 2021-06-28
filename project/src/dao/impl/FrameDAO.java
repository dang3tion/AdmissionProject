package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import connection.AccessDatabase;
import dao.IFrameDAO;
import mapper.FrameMapper;
import model.TrainingFrame;

public class FrameDAO implements IFrameDAO {
	private static FrameDAO ins = new FrameDAO();

	public FrameDAO() {

	}

	public static FrameDAO getInstance() {
		if (ins == null) {
			ins = new FrameDAO();
		}
		return ins;
	}

	@Override
	public boolean insertFrame(TrainingFrame frame, String id) {
		AccessDatabase ac = AccessDatabase.getInstance();
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String date = localDate.format(formatter);
		String query = "INSERT INTO KHUNGDT_TRUONG VALUES(?,?,?,?,?,'1')";

		try (ResultSet rs = ac.executeQuery(query, frame.getTypeFrame(), date, frame.getDescription(), frame.getState(),
				id)) {
			String idFrame = getIDFrameUnique(id, frame.getTypeFrame(), date);
			for (int i = 0; i < frame.getListCourse().size(); i++) {
				CourseDAO.getInstance().addCourse(frame.getListCourse().get(i), idFrame);
			}

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getIDFrameUnique(String idTruong, String idFrame, String date) {
		AccessDatabase ac = AccessDatabase.getInstance();
		String query = "SELECT ID_KDT FROM KHUNGDT_TRUONG WHERE ID_TRUONG=? and NGAYCAPNHAT=? and ID_KHUNG=?";

		try (ResultSet rs = ac.executeQuery(query, idTruong, date, idFrame)) {
			while (rs.next()) {
				return rs.getString("ID_KDT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getInstance().getIDFrameUnique("2", "1", "2021/11/2"));
	}

	@Override
	public List<TrainingFrame> getListFrame() {
		// TODO Auto-generated method stub
		return null;
	}
}
