package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.CollegesInfo;

public class CollegesMapper implements RowMapper<CollegesInfo>{

	@Override
	public CollegesInfo mapper(ResultSet rs) {
		CollegesInfo info = new CollegesInfo();
		
		return info;
	}

}
