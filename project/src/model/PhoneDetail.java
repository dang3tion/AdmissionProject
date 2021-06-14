package model;

public class PhoneDetail {
	private String title;
	private String phoneNo;
	private String state;

	public PhoneDetail(String title, String phoneNo, String state) {
		super();
		this.title = title;
		this.phoneNo = phoneNo;
		this.state = state;
	}

	public PhoneDetail() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "PhoneDetail [title=" + title + ", phoneNo=" + phoneNo + ", state=" + state + "]";
	}

}
