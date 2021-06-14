package dao;

import java.util.List;

import model.CollegesInfo;
import page.Page;

public interface ICollegesDAO extends IGenericDAO<CollegesInfo> {
	public List<CollegesInfo> searchColleges(String search, Page page, Object... params);

	public boolean isIdExists(String id);
}
