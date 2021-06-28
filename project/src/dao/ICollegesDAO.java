package dao;

import java.util.List;

import model.CollegesInfo;

public interface ICollegesDAO {
	public List<CollegesInfo> searchColleges(String search, Object... params);

	public boolean isIdExists(String id);
}
