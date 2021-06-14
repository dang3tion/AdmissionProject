package mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.AddressDetail;
import model.Course;
import model.Images;
import model.PhoneDetail;
import model.TrainingFrame;

public interface MapperRequest {
	public List<AddressDetail> createAddress(HttpServletRequest request);

	public List<PhoneDetail> createPhoneDetail(HttpServletRequest request);

	public List<Images> createListImage(HttpServletRequest request);

	public List<TrainingFrame> createListFrame(HttpServletRequest request);

	public List<Course> createListCourse(HttpServletRequest request, int id);
}
