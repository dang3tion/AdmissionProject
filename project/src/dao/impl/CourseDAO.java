package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connection.AccessDatabase;
import dao.ICourseDAO;
import mapper.CourseMapper;
import model.Course;

public class CourseDAO extends AbstractDAO<Course> implements ICourseDAO {
	private static CourseDAO instance = new CourseDAO();

	public static CourseDAO getInstance() {
		return instance;
	}

	private CourseDAO() {
	}

	@Override
	public int doInsert(Course t, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean doUpdate(Course t, Object... params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(int id, Object... params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course doGet(int id, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourses() {
		String sql = "SELECT * FROM NGANH";
		return query(sql, new CourseMapper());
	}

	public static void main(String[] args) {
		System.out.println(CourseDAO.getInstance().getCourses());
	}

	@Override
	public boolean addCourse(Course course, String idFrame) {
		AccessDatabase ac = AccessDatabase.getInstance();
		String query = "INSERT INTO NGANH_KHUNGDT VALUES(?,?,?,?,?,'1')";
		try (ResultSet rs = ac.executeQuery(query, idFrame, course.getName(), course.getGrade(),
				course.getRecruimentQuantity(), course.getDesciption())) {
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
