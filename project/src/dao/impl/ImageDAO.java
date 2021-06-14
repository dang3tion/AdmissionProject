package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.AccessDatabase;
import dao.IImageDAO;
import model.Images;
import model.PhoneDetail;

public class ImageDAO implements IImageDAO{
	private static ImageDAO ins = new ImageDAO();

	public ImageDAO() {

	}

	public static ImageDAO getInstance() {
		if (ins == null) {
			ins = new ImageDAO();
		}
		return ins;
	}


	@Override
	public boolean insertImage(Images img, String id) {
		AccessDatabase ac = AccessDatabase.getInstance();
		String query = "INSERT INTO HINHANH VALUES(?,?,'',?)";
		try (ResultSet rs = ac.executeQuery(query,img.getTitle(),img.getUrl(), id)) {
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
