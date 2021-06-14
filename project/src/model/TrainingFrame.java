package model;

import java.util.List;

public class TrainingFrame {
	private String typeFrame;
	private String updateTime;
	private String description;
	private String tuition;
	private double value_tuition;
	private String descriTuition;
	private List<Course> listCourse;
	private String id;
	private String state;
	public TrainingFrame(String typeFrame, String updateTime, String description, String tuition, double value_tuition,
			String descriTuition, List<Course> listCourse) {
		super();
		this.typeFrame = typeFrame;
		this.updateTime = updateTime;
		this.description = description;
		this.tuition = tuition;
		this.value_tuition = value_tuition;
		this.descriTuition = descriTuition;
		this.listCourse = listCourse;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TrainingFrame() {
		super();
	}

	public String getTypeFrame() {
		return typeFrame;
	}

	public void setTypeFrame(String typeFrame) {
		this.typeFrame = typeFrame;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	public double getValue_tuition() {
		return value_tuition;
	}

	public void setValue_tuition(double value_tuition) {
		this.value_tuition = value_tuition;
	}

	public String getDescriTuition() {
		return descriTuition;
	}

	public void setDescriTuition(String descriTuition) {
		this.descriTuition = descriTuition;
	}

	public List<Course> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}

	@Override
	public String toString() {
		return "TrainingFrame [typeFrame=" + typeFrame + ", updateTime=" + updateTime + ", description=" + description
				+ ", tuition=" + tuition + ", value_tuition=" + value_tuition + ", descriTuition=" + descriTuition
				+ ", listCourse=" + listCourse + "]";
	}

	

}
