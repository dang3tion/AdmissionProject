package dao.impl;

import connection.AccessDatabase;
import model.AddressDetail;
import model.CollegesInfo;
import model.Images;

import java.sql.ResultSet;
import java.util.ArrayList;

public class FilterDAO implements dao.IFilterDAO {
    private static FilterDAO filter = new FilterDAO();

    public FilterDAO() {

    }

    public static FilterDAO getInstance() {
        if (filter == null) {
            filter = new FilterDAO();
        }
        return filter;
    }


    @Override
    public ArrayList<CollegesInfo> getList(String[] type) {
        String query = "";
        int a = -1;
        if (type[0].equalsIgnoreCase("All") && type[1].equalsIgnoreCase("All")){
            a = 2;
            query = "SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t WHERE t.LOAITRUONG = '"+type[2]+"'";
        }
        else if (type[0].equalsIgnoreCase("All")){
            a = 0;
            query = "SELECT t.TENTRUONG, k.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t, KHUNGDT_TRUONG k , NGANH_KHUNGDT n, NGANH ng WHERE k.ID_KDT = n.ID_KDT AND t.LOAITRUONG = '"+type[2]+"' AND k.ID_TRUONG = t.ID_TRUONG AND n.ID_NGANH = ng.ID_NGANH AND ng.TEN_NGANH = N'"+type[1]+"'";
        }
        else if (type[1].equalsIgnoreCase("All")){
            a = 1;
            query = "SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t, DIACHI d WHERE t.LOAITRUONG = '"+type[2]+"' AND d.ID_TRUONG = t.ID_TRUONG AND d.TINH = '"+type[0]+"'";
        }
        else{
            a = 3;
            query = "SELECT t.TENTRUONG, k.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t, KHUNGDT_TRUONG k , NGANH_KHUNGDT n, NGANH ng, DIACHI d WHERE k.ID_KDT = n.ID_KDT AND t.LOAITRUONG = '"+type[2]+"' AND k.ID_TRUONG = t.ID_TRUONG AND n.ID_NGANH = ng.ID_NGANH AND ng.TEN_NGANH = N'"+type[1]+"' AND d.ID_TRUONG = t.ID_TRUONG AND d.TINH = '"+type[0]+"'";
        }
        ArrayList<CollegesInfo> collegesInfos = new ArrayList<>();
        AccessDatabase database = AccessDatabase.getInstance();

        // lấy thông tin trường học
        try (ResultSet rs = database.executeQuery(query)){
            while (rs.next()){
                CollegesInfo collegesInfo = new CollegesInfo();
                collegesInfo.setName(rs.getString("TENTRUONG"));
                collegesInfo.setIdColleges(rs.getInt("ID_TRUONG")+"");
                collegesInfo.setType(rs.getString("LOAITRUONG"));
                collegesInfo.setWebsite(rs.getString("WEBSITE"));
                collegesInfo.setAdmissionDetail(rs.getString("TT_TUYENSINH"));
                collegesInfo.setState(rs.getString("TRANGTHAI"));


                // lấy danh sách hình ảnh
                String queryKTD = "SELECT TIEUDE,URL_ANH,TRANGTHAI FROM HINHANH WHERE ID_TRUONG = ?";
                ArrayList<Images> images = new ArrayList<>();
                try (ResultSet rsKTD = database.executeQuery(queryKTD,collegesInfo.getIdColleges())){
                    while (rsKTD.next()){
                        String title = rsKTD.getString("TIEUDE");
                        String url = rsKTD.getString("URL_ANH");
                        String state = rsKTD.getString("TRANGTHAI");
                        images.add(new Images(title,url,state));
                    }
                    collegesInfo.setLstImg(images);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                // lấy địa chỉ
                String queryDC = "SELECT TIEUDE,DIACHI,TINH,QUAN_HUYEN,TRANGTHAI FROM DIACHI WHERE ID_TRUONG = ?";
                ArrayList<AddressDetail> addressDetails = new ArrayList<>();
                try (ResultSet rsDC = database.executeQuery(queryDC,collegesInfo.getIdColleges())){
                    while (rsDC.next()){
                        AddressDetail address = new AddressDetail();
                        address.setTitle(rsDC.getString("TIEUDE"));
                        address.setAddress(rsDC.getString("DIACHI"));
                        address.setCity(rsDC.getString("TINH"));
                        address.setDistrict(rsDC.getString("QUAN_HUYEN"));
                        address.setState(rsDC.getString("TRANGTHAI"));
                        addressDetails.add(address);
                    }
                    collegesInfo.setListAdress(addressDetails);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                collegesInfos.add(collegesInfo);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return collegesInfos;
    }
    public ArrayList<String> loadMajors(){
        ArrayList<String> majors = new ArrayList<>();
        majors.add("All");
        String query = "SELECT TEN_NGANH FROM NGANH";
        AccessDatabase database = AccessDatabase.getInstance();
        try(ResultSet rs = database.executeQuery(query)){
            while (rs.next()){
                majors.add(rs.getString("TEN_NGANH"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return majors;
    }

    public static void main(String[] args) {
        FilterDAO dao = new FilterDAO();
        String[] params = {"tphcm","Kỹ thuật Máy tính","daihoc"};
        for (CollegesInfo c: dao.getList(params)){
            System.out.println(c);
        }
       // System.out.println(dao.loadMajors().toString());
    }
}
