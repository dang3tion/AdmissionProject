package dao.impl;

import connection.AccessDatabase;
import dao.ISearchDAO;
import model.AddressDetail;
import model.CollegesInfo;
import model.Images;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class SearchDAO implements ISearchDAO {
    private static SearchDAO search = new SearchDAO();

    private static int numberPage;
    private int numberPerPage = 1;
    public static int sumResult;

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
        ArrayList<CollegesInfo> collegesInfos = new ArrayList<>();
        String query = "SELECT t.TENTRUONG, t.ID_TRUONG,t.LOAITRUONG,t.WEBSITE,t.TT_TUYENSINH,t.TRANGTHAI FROM TRUONGHOC t WHERE t.TENTRUONG LIKE '%"+keyword.trim()+"%'";
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
    public HashSet<String> getHint(String keyword){
        HashSet<String> result = new HashSet<>();
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

            String query2 = "SELECT TENTRUONG FROM TRUONGHOC ";

            try (ResultSet rs = database.executeQuery(query2)) {
                System.out.println(query2);
                while (rs.next()) {
                    String s = (rs.getString("TENTRUONG"));
                        if (keyword.indexOf(s) != -1) {
                            result.add(s);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            result.addAll(searchHelp(keyword));

            return result;
        }
    }
    public HashSet<String> searchHelp(String keyword){
        HashSet<String> result = new HashSet<>();
        String[] k = keyword.trim().split(" ");
            for (String s : k){
                for (String st : searchQuery(s)){
                    result.add(st);
                }
            }
        return result;
    }
    public HashSet<String> searchQuery(String keyword){
        HashSet<String> result = new HashSet<>();
        String query = "SELECT TENTRUONG FROM TRUONGHOC WHERE TENTRUONG LIKE '%"+keyword+"%'";
        AccessDatabase database = AccessDatabase.getInstance();
        try(ResultSet rs = database.executeQuery(query)){
            while (rs.next()){
                result.add(rs.getString("TENTRUONG"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<String> loadMajors(){
        ArrayList<String> majors = new ArrayList<>();
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
    public ArrayList<CollegesInfo> getList(String keyword,int page) {

        ArrayList<CollegesInfo> collegesInfos = new ArrayList<>();
        String queryS = "SELECT t.TENTRUONG, t.ID_TRUONG,t.LOAITRUONG,t.WEBSITE,t.TT_TUYENSINH,t.TRANGTHAI FROM TRUONGHOC t WHERE t.TENTRUONG LIKE '%"+keyword.trim()+"%'";
        AccessDatabase database = AccessDatabase.getInstance();
        try (ResultSet rs = database.executeQuery(queryS)){
            int count = 0;
            while(rs.next()){
                count++;
            }
            sumResult = count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int start = (page - 1)*numberPerPage + 1;

        if (sumResult % numberPerPage == 0){
            setNumberPage(sumResult/numberPerPage);
        }
        else{
            setNumberPage(sumResult/numberPerPage+1);
        }

        String query = "SELECT * FROM (SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI, ROW_NUMBER() OVER (ORDER BY t.ID_TRUONG)\n" +
                " as row FROM TRUONGHOC t WHERE t.TENTRUONG LIKE '%"+keyword.trim()+"%') a WHERE row >="+start+" and row <"+(start+numberPerPage);

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

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public static int getSumResult() {
        return sumResult;
    }

    public static void setSumResult(int sumResult) {
        FilterDAO.sumResult = sumResult;
    }

    public static void main(String[] args) {
        SearchDAO dao = new SearchDAO();
        for (CollegesInfo c : dao.getList("h",3)){
            System.out.println(c);
        }

    }

}
