package bo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CollegesInfo;

public interface ICollegesBO {
	public List<CollegesInfo> searchColleges(String search);

	public List<CollegesInfo> searchColleges(String search, Object... params);

	public boolean isIdExists(String id);

	public boolean createNewObject(HttpServletRequest request);

}
