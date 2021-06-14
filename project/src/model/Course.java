package model;

import java.util.List;

public class Course {
	private String id;
	private String name;
	private double grade;
	private List<String> recruimentCombination; 
	private int recruimentQuantity;
	private String desciption;
	
	public Course(String name, double grade, List<String> recruimentCombination, int recruimentQuantity,
			String desciption) {
		super();
		this.name = name;
		this.grade = grade;
		this.recruimentCombination = recruimentCombination;
		this.recruimentQuantity = recruimentQuantity;
		this.desciption = desciption;
	}
	public Course() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public List<String> getRecruimentCombination() {
		return recruimentCombination;
	}
	public void setRecruimentCombination(List<String> recruimentCombination) {
		this.recruimentCombination = recruimentCombination;
	}
	public int getRecruimentQuantity() {
		return recruimentQuantity;
	}
	public void setRecruimentQuantity(int recruimentQuantity) {
		this.recruimentQuantity = recruimentQuantity;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", grade=" + grade + ", recruimentCombination=" + recruimentCombination
				+ ", recruimentQuantity=" + recruimentQuantity + ", desciption=" + desciption + "]";
	}
	
}
