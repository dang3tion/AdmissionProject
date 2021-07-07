package dao.impl;

import connection.AccessDatabase;
import dao.ISearchDAO;
import model.AddressDetail;
import model.CollegesInfo;
import model.Images;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchDAO implements ISearchDAO {
    private static SearchDAO search = new SearchDAO();

    public SearchDAO(){

    }
    public static SearchDAO getInstance() {
        if (search == null) {
            search = new SearchDAO();
        }
        return search;
    }
    @Override
    public ArrayList<CollegesInfo> getList(String keyword) {
        ArrayList<CollegesInfo> colleges = new ArrayList<>();
        String query = "SELECT t.MATRUONG, t.ID_TRUONG,t.LOAITRUONG,t.WEBSITE,t.TT_TUYENSINH,t.TRANGTHAI FROM TRUONGHOC t WHERE TRANGTHAI = 'hoat dong'";
        AccessDatabase database = AccessDatabase.getInstance();
        try(ResultSet rs = database.executeQuery(query,keyword)){
            while (rs.next()){
                CollegesInfo collegesInfo = new CollegesInfo();
                collegesInfo.setName(rs.getString("MATRUONG"));
                collegesInfo.setIdColleges(rs.getString("ID_TRUONG"));
                collegesInfo.setType(rs.getString("LOAITRUONG"));
                collegesInfo.setWebsite(rs.getString("WEBSITE"));
                collegesInfo.setAdmissionDetail(rs.getString("TT_TUYENSINH"));
                collegesInfo.setState(rs.getString("TRANGTHAI"));


                // lấy danh sách hình ảnh
                String queryKTD = "SELECT TIEUDE,URL_ANH_TRANGTHAI HINHANH WHERE ID_TRUONG = ? AND TRANGTHAI = 'active' GROUP BY ID_TRUONG";
                ArrayList<Images> images = new ArrayList<>();
                try (ResultSet rsKTD = database.executeQuery(queryKTD,collegesInfo.getIdColleges())){
                    if (rsKTD.next()){
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
                String queryDC = "SELECT TIEUDE,DIACHI,TINH,QUAN_HUYEN,TRANGTHAI FROM DIACHI WHERE ID_TRUONG = ? AND TRANGTHAI = 'hoat dong'";
                ArrayList<AddressDetail> addressDetails = new ArrayList<>();
                try (ResultSet rsDC = database.executeQuery(query,collegesInfo.getIdColleges())){
                    while (rs.next()){
                        AddressDetail address = new AddressDetail();
                        address.setTitle(rsDC.getString("TIEUDE"));
                        address.setAddress(rsDC.getString("DIACHI"));
                        address.setCity(rsDC.getString("TINH"));
                        address.setDistrict(rsDC.getString("QUAN_HUYEN"));
                        address.setState(rsDC.getString("TRANGTHAI"));
                        addressDetails.add(address);
                    }
                    collegesInfo.setListAdress(addressDetails);
                    colleges.add(collegesInfo);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return colleges;
    }
    public ArrayList<String> getHint(String keyword){
        ArrayList<String> result = new ArrayList<>();
        String key = keyword.trim();

        if (key.equals("")){
            return result;
        }
        else {
            String query = "SELECT TENTRUONG FROM TRUONGHOC WHERE TENTRUONG LIKE N'%" + key + "%'";

            AccessDatabase database = AccessDatabase.getInstance();
            try (ResultSet rs = database.executeQuery(query)) {
                System.out.println(query);
                while (rs.next()) {
                    result.add(rs.getString("TENTRUONG"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static void main(String[] args) {
        SearchDAO dao = new SearchDAO();
        for (String s : dao.getHint("k")){
            System.out.println(s);
        }

    }
}
