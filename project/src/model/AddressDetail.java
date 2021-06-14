package model;

public class AddressDetail {
	private String title;
	private String address;
	private String city;
	private String district;
	private String state;

	public AddressDetail(String title, String address, String city, String district, String state) {
		super();
		this.title = title;
		this.address = address;
		this.city = city;
		this.district = district;
		this.state = state;
	}

	public AddressDetail() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AddressDetail [title=" + title + ", address=" + address + ", city=" + city + ", district=" + district
				+ ", state=" + state + "]";
	}
}
