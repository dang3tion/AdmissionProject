package bo.impl;

import java.util.List;

import bo.ICourseBO;
import dao.ICourseDAO;
import dao.impl.CourseDAO;
import model.Course;

public class CourseBO implements ICourseBO {
	private static CourseBO instance = new CourseBO();

	public static CourseBO getInstance() {
		return instance;
	}

	private CourseBO() {
	};

	private ICourseDAO courseDAO = CourseDAO.getInstance();

	@Override
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	public static void main(String[] args) {
		System.out.println("asd".charAt(0));
	}
}
