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

public class MapperList implements MapperRequest {
	private static MapperList ins = new MapperList();

	private MapperList() {

	}

	public static MapperList getInstance() {
		if (ins == null) {
			ins = new MapperList();
		}
		return ins;
	}

	@Override
	public List<AddressDetail> createAddress(HttpServletRequest request) {
		List<AddressDetail> lstAddress = new ArrayList<AddressDetail>();
		String[] tieude = request.getParameterValues("tieude-diachi");
		for (int i = 0; i < tieude.length; i++) {
			AddressDetail ad = new AddressDetail();
			ad.setTitle(tieude[i].trim());
			ad.setAddress(request.getParameterValues("diachi")[i].trim());
			ad.setCity(request.getParameterValues("diachi-tinh")[i].trim());
			ad.setDistrict(request.getParameterValues("diachi-huyen")[i].trim());
			ad.setState(request.getParameterValues("diachi-trangthai")[i].trim());
			lstAddress.add(ad);
		}
		return lstAddress;
	}

	@Override
	public List<PhoneDetail> createPhoneDetail(HttpServletRequest request) {
		List<PhoneDetail> lstPhone = new ArrayList<PhoneDetail>();
		String[] tieude = request.getParameterValues("sdt-tieude");
		for (int i = 0; i < tieude.length; i++) {
			PhoneDetail po = new PhoneDetail();
			po.setTitle(tieude[i].trim());
			po.setPhoneNo(request.getParameterValues("sdt")[i].trim());
			po.setState(request.getParameterValues("sdt-trangthai")[i].trim());
			lstPhone.add(po);
		}
		return lstPhone;
	}

	@Override
	public List<Images> createListImage(HttpServletRequest request) {
		List<Images> lstIm = new ArrayList<Images>();
		String anhnen = request.getParameter("anh-nen");
		lstIm.add(new Images("nen", anhnen.trim(), ""));
		String logo = request.getParameter("logo");
		lstIm.add(new Images("logo", logo.trim(), ""));
		String[] anhphu = request.getParameterValues("anh-phu");
		for (int i = 0; i < anhphu.length; i++) {
			lstIm.add(new Images("phu", anhphu[i].trim(), ""));
		}
		return lstIm;
	}

	@Override
	public List<TrainingFrame> createListFrame(HttpServletRequest request) {
		List<TrainingFrame> lstFrame = new ArrayList<TrainingFrame>();
		String[] nam = request.getParameterValues("khung-nam");
		for (int i = 0; i < nam.length; i++) {
			TrainingFrame frame = new TrainingFrame();
			String loaikhung = request.getParameterValues("loai-khung")[i].trim();
			String mota = request.getParameterValues("mota-khung")[i].trim();
			String hocphi = request.getParameterValues("hocphi")[i].trim();
			String giatri = request.getParameterValues("giatri-hocphi")[i].trim();
			String mota_hocphi = request.getParameterValues("mota-hocphi")[i].trim();
			String trangthai = request.getParameterValues("trangthai-khung")[i].trim();

			List<Course> lstCourse = createListCourse(request, i + 1);
			frame.setUpdateTime(nam[i]);
			frame.setTypeFrame(loaikhung);
			frame.setDescription(mota);
			frame.setTuition(hocphi);
			frame.setValue_tuition(Double.parseDouble(giatri));
			frame.setDescriTuition(mota_hocphi);
			frame.setListCourse(lstCourse);
			frame.setState(trangthai);
			lstFrame.add(frame);
		}
		return lstFrame;

	}

	@Override
	public List<Course> createListCourse(HttpServletRequest request, int id) {
		List<Course> lstCourse = new ArrayList<Course>();
		String[] nganh = request.getParameterValues("nganh" + id);
		for (int i = 0; i < nganh.length; i++) {
			Course course = new Course();
			String diem = request.getParameterValues("diem-nganh" + id)[i].trim();
			String chitieu = request.getParameterValues("chitieu-nganh" + id)[i].trim();
			String tohop = request.getParameterValues("tohop-nganh" + id)[i].trim();
			String mota = request.getParameterValues("mota-nganh" + id)[i].trim();
			course.setName(nganh[i].trim());
			course.setGrade(Double.parseDouble(diem));
			course.setRecruimentQuantity(Integer.parseInt(chitieu));
			course.setDesciption(mota);
			course.setRecruimentCombination(new ArrayList<String>(Arrays.asList(tohop.split(","))));
			lstCourse.add(course);

		}
		return lstCourse;
	}
}
