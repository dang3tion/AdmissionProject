package bo.impl;

import java.util.List;

import bo.IFrameBO;
import dao.ICourseDAO;
import dao.impl.CourseDAO;
import dao.impl.FrameDAO;
import model.TrainingFrame;

public class FrameBO implements IFrameBO{
	private static FrameBO instance = new FrameBO();
	public static FrameBO getInstance() {
		return instance;
	}
	private FrameBO() {};

	
	@Override
	public List<TrainingFrame> getListFrame() {
		// TODO Auto-generated method stub
		return FrameDAO.getInstance().getListFrame();
	}

}
