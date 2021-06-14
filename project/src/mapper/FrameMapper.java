package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.TrainingFrame;

public class FrameMapper implements RowMapper<TrainingFrame>{

	@Override
	public TrainingFrame mapper(ResultSet rs) {
		TrainingFrame t=new TrainingFrame();
		try {
			t.setId(rs.getString("ID_KHUNG"));
			t.setTypeFrame(rs.getString("LOAIKHUNG"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
