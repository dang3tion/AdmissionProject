package dao;

import java.util.List;

import model.TrainingFrame;

public interface IFrameDAO {
	public boolean insertFrame(TrainingFrame frame, String id);

	public List<TrainingFrame> getListFrame();
}
