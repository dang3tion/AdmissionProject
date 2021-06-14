package dao;

import java.util.List;

import model.Course;

public interface ICourseDAO extends IGenericDAO<Course>{
	public List<Course> getCourses();
	public boolean addCourse(Course course,String idFrame);
}
