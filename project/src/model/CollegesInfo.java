package model;

import java.util.List;

public class CollegesInfo {

	private String name;
	private String idColleges;
	private String type;

	private String website;
	private String email;
	private String introduce;
	private String admissionDetail;
	private String state;
	private List<TrainingFrame> listFrame;
	private List<AddressDetail> listAdress;
	private List<PhoneDetail> listPhone;
	private List<Images> lstImg;


	public CollegesInfo(String name, String idColleges, String type, String website, String email, String introduce,
			String admissionDetail, String state, List<TrainingFrame> listFrame, List<AddressDetail> listAdress,
			List<PhoneDetail> listPhone, List<Images> lstImg) {
		super();
		this.name = name;
		this.idColleges = idColleges;
		this.type = type;
		this.website = website;
		this.email = email;
		this.introduce = introduce;
		this.admissionDetail = admissionDetail;
		this.state = state;
		this.listFrame = listFrame;
		this.listAdress = listAdress;
		this.listPhone = listPhone;
		this.lstImg = lstImg;
	}

	public CollegesInfo(String name, String idColleges, String type, String website, String email, String introduce,
			String admissionDetail, String state) {
		super();
		this.name = name;
		this.idColleges = idColleges;
		this.type = type;
		this.website = website;
		this.email = email;
		this.introduce = introduce;
		this.admissionDetail = admissionDetail;
		this.state = state;
	}

	public CollegesInfo() {
		super();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdColleges() {
		return idColleges;
	}

	public void setIdColleges(String idColleges) {
		this.idColleges = idColleges;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAdmissionDetail() {
		return admissionDetail;
	}

	public void setAdmissionDetail(String admissionDetail) {
		this.admissionDetail = admissionDetail;
	}

	public List<TrainingFrame> getListFrame() {
		return listFrame;
	}

	public void setListFrame(List<TrainingFrame> listFrame) {
		this.listFrame = listFrame;
	}

	public List<AddressDetail> getListAdress() {
		return listAdress;
	}

	public void setListAdress(List<AddressDetail> listAdress) {
		this.listAdress = listAdress;
	}

	public List<PhoneDetail> getListPhone() {
		return listPhone;
	}

	public void setListPhone(List<PhoneDetail> listPhone) {
		this.listPhone = listPhone;
	}

	public List<Images> getLstImg() {
		return lstImg;
	}

	public void setLstImg(List<Images> lstImg) {
		this.lstImg = lstImg;
	}

	@Override
	public String toString() {
		return "CollegesInfo [name=" + name + ", idColleges=" + idColleges + ", type=" + type + ", website=" + website + ", email=" + email + ", introduce=" + introduce
				+ ", admissionDetail=" + admissionDetail + ", listFrame=" + listFrame + ", listAdress=" + listAdress
				+ ", listPhone=" + listPhone + ", lstImg=" + lstImg + "]";
	}

}