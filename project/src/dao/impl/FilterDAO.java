package dao.impl;

import connection.AccessDatabase;
import model.AddressDetail;
import model.CollegesInfo;
import model.Images;

import java.sql.ResultSet;
import java.util.ArrayList;

public class FilterDAO implements dao.IFilterDAO {
    private static FilterDAO filter = new FilterDAO();

    private static int numberPage;
    private int numberPerPage = 1;
    public static int sumResult;

    public FilterDAO() {

    }

    public static FilterDAO getInstance() {
        if (filter == null) {
            filter = new FilterDAO();
        }
        return filter;
    }


    @Override
    public ArrayList<CollegesInfo> filter(String[] type) {
        String query = "";
        if (type[0].equalsIgnoreCase("All") && type[1].equalsIgnoreCase("All")){
            query = "SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t WHERE t.LOAITRUONG = '"+type[2]+"'";
        }
        else if (type[0].equalsIgnoreCase("All")){
            query = "SELECT t.TENTRUONG, k.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t, KHUNGDT_TRUONG k , NGANH_KHUNGDT n, NGANH ng WHERE k.ID_KDT = n.ID_KDT AND t.LOAITRUONG = '"+type[2]+"' AND k.ID_TRUONG = t.ID_TRUONG AND n.ID_NGANH = ng.ID_NGANH AND ng.TEN_NGANH = N'"+type[1]+"'";
        }
        else if (type[1].equalsIgnoreCase("All")){
            query = "SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t, DIACHI d WHERE t.LOAITRUONG = '"+type[2]+"' AND d.ID_TRUONG = t.ID_TRUONG AND d.TINH = '"+type[0]+"'";
        }
        else{
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
    public ArrayList<CollegesInfo> filter(String[] type, int page) {
        String queryS = "";
        if (type[0].equalsIgnoreCase("All") && type[1].equalsIgnoreCase("All")){
            queryS = "SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t WHERE t.LOAITRUONG = '"+type[2]+"'";
        }
        else if (type[0].equalsIgnoreCase("All")){
            queryS = "SELECT t.TENTRUONG, k.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t, KHUNGDT_TRUONG k , NGANH_KHUNGDT n, NGANH ng WHERE k.ID_KDT = n.ID_KDT AND t.LOAITRUONG = '"+type[2]+"' AND k.ID_TRUONG = t.ID_TRUONG AND n.ID_NGANH = ng.ID_NGANH AND ng.TEN_NGANH = N'"+type[1]+"'";
        }
        else if (type[1].equalsIgnoreCase("All")){
            queryS = "SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t, DIACHI d WHERE t.LOAITRUONG = '"+type[2]+"' AND d.ID_TRUONG = t.ID_TRUONG AND d.TINH = '"+type[0]+"'";
        }
        else{
            queryS = "SELECT t.TENTRUONG, k.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI FROM TRUONGHOC t, KHUNGDT_TRUONG k , NGANH_KHUNGDT n, NGANH ng, DIACHI d WHERE k.ID_KDT = n.ID_KDT AND t.LOAITRUONG = '"+type[2]+"' AND k.ID_TRUONG = t.ID_TRUONG AND n.ID_NGANH = ng.ID_NGANH AND ng.TEN_NGANH = N'"+type[1]+"' AND d.ID_TRUONG = t.ID_TRUONG AND d.TINH = '"+type[0]+"'";
        }
        // lấy tổng số lượng trường học
        AccessDatabase databaseS = AccessDatabase.getInstance();
        try(ResultSet rs = databaseS.executeQuery(queryS)){
            int count=0;
           while (rs.next()){
               count++;
           }
           sumResult=count;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        int start = (page-1)*numberPerPage + 1;

        if (sumResult % numberPerPage == 0){
            setNumberPage(sumResult/numberPerPage);
        }
        else{
            setNumberPage(sumResult/numberPerPage+1);
        }

        String query = "";
        if (type[0].equalsIgnoreCase("All") && type[1].equalsIgnoreCase("All")){
            query = "SELECT * FROM (SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI, ROW_NUMBER() " +
                    "OVER (ORDER BY t.ID_TRUONG) as row FROM TRUONGHOC t WHERE t.LOAITRUONG = '"+type[2]+"'" +
                    " ) a WHERE row >= "+start+" and row <="+(start*numberPerPage);
        }
        else if (type[0].equalsIgnoreCase("All")){
            query = "SELECT * FROM (SELECT t.TENTRUONG, k.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI," +
                    " ROW_NUMBER() OVER (ORDER BY t.ID_TRUONG) as row FROM TRUONGHOC t, KHUNGDT_TRUONG k , NGANH_KHUNGDT n, " +
                    "NGANH ng WHERE k.ID_KDT = n.ID_KDT AND t.LOAITRUONG = '"+type[2]+"' AND k.ID_TRUONG = t.ID_TRUONG AND n.ID_NGANH " +
                    "= ng.ID_NGANH AND ng.TEN_NGANH = N'"+type[1]+"'" +
                    ") a WHERE row >= "+start+" and row <="+(start*numberPerPage);
        }
        else if (type[1].equalsIgnoreCase("All")){
            query = "SELECT * FROM (SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI," +
                    " ROW_NUMBER() OVER (ORDER BY t.ID_TRUONG) as row FROM TRUONGHOC t, DIACHI d  WHERE t.LOAITRUONG = '"+type[2]+"' " +
                    "AND d.ID_TRUONG = t.ID_TRUONG AND d.TINH = '"+type[0]+"'" +
                    ") a WHERE row >= "+start+" and row <="+(start*numberPerPage);
        }
        else{
            query = "SELECT * FROM (SELECT t.TENTRUONG, t.ID_TRUONG ,t.LOAITRUONG, t.WEBSITE, t.TT_TUYENSINH, t.TRANGTHAI, " +
                    "ROW_NUMBER() OVER (ORDER BY t.ID_TRUONG) as row FROM TRUONGHOC t, KHUNGDT_TRUONG k , NGANH_KHUNGDT n, NGANH ng," +
                    " DIACHI d WHERE k.ID_KDT = n.ID_KDT AND t.LOAITRUONG = '"+type[2]+"' AND k.ID_TRUONG = t.ID_TRUONG AND n.ID_NGANH = " +
                    "ng.ID_NGANH AND ng.TEN_NGANH = N'"+type[1]+"' AND d.ID_TRUONG = t.ID_TRUONG AND d.TINH = '"+type[0]+"'" +
                    ") a WHERE row >= "+start+" and row <="+(start*numberPerPage);
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
                System.out.println(sumResult+"----"+getNumberPage());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return collegesInfos;
    }
    public ArrayList<CollegesInfo> getAllList(int page){
        ArrayList<CollegesInfo> collegesInfos = new ArrayList<>();
        String[] params = {"All","All","daihoc"};
        collegesInfos = filter(params,1);
        return collegesInfos;
    }

    public static void main(String[] args) {
        FilterDAO dao = new FilterDAO();
        String[] params = {"All","All","daihoc"};
        for (CollegesInfo c: dao.filter(params,1)){
            System.out.println(c);
        }
       // System.out.println(dao.loadMajors().toString());
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
}
