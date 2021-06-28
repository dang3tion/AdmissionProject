package bo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CollegesInfo;

public interface ICollegesBO {

	public boolean isIdExists(String id);

	public boolean createNewObject(HttpServletRequest request);

}
