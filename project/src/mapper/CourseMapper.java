package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Course;

public class CourseMapper implements RowMapper<Course>{

	@Override
	public Course mapper(ResultSet rs) {
		Course course = new Course();
		try {
			course.setName(rs.getString("TEN_NGANH"));
			course.setId(rs.getString("ID_NGANH").trim());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return course;
	}

}
