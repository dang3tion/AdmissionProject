package controller.client.filter;

import dao.impl.FilterDAO;
import model.CollegesInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet (urlPatterns = "/filter", name = "filter")
public class FilterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] params = {"All","All","daihoc"};

        if (req.getParameter("province")!=null) {

            String province = req.getParameter("province");
            String major = req.getParameter("major");
            String type = req.getParameter("type");

            params[0] = province;
            params[1] = major;
            params[2] = type;
        }

        filter(params,req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    private void filter(String[] type,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FilterDAO dao = new FilterDAO();
        ArrayList<String> majors = dao.loadMajors();

        int page = 1;
        if (req.getParameter("page") != null){
            page = Integer.parseInt(req.getParameter("page"));
        }

        req.setAttribute("majors",majors);

        ArrayList<CollegesInfo> list = dao.filter(type,page);
        req.setAttribute("list",list);

        int numberPage = dao.getNumberPage();
        req.setAttribute("numberPage",numberPage);

        for (String s : type){
            System.out.println(s);
        }
        System.out.println(list);

//
       // req.getRequestDispatcher("view/jsp/page/FilterUI.jsp?page="+page).forward(req,resp);

        PrintWriter writer = resp.getWriter();
        if (list.size() > 0) {
            for (CollegesInfo c : list) {
                writer.println("<div class=\"col-md-6 \" element >\n" +
                        "                                <a class=\" hover-bg-enlarge link-normal\" href=\"/college-list?action=detail&id=" + c.getIdColleges() + ">\">\n" +
                        "                                      <div class=\"propertie-item set-bg2 \" style=\"\">\n " +
                        "                                        <div class=\"propertie-info text-white\" style=\"background-color: rgba(0, 0, 0, 0.212);\">\n" +
                        "                                            <div class=\"info-warp\">\n" +
                        "                                                <h5>" + c.getName() + "</h5>\n" +
                        "                                                <p>\n" +
                        "                                                    " + c.getIntroduce() + "\n" +
                        "                                                    <br/>\n" +
                        "                                                   Website: <a class=\"link-normal\" href=\"" + c.getWebsite() + "\">" + c.getWebsite() + "</a>\n" +
                        "                                                </p>\n" +
                        "                                            </div>\n" +
                        "                                            <p class=\"price2 mb-0\">\n" +
                        "                                                <span class=\"icon-star text-warning\"></span>\n" +
                        "                                                <span class=\"icon-star text-warning\"></span>\n" +
                        "                                                <span class=\"icon-star text-warning\"></span>\n" +
                        "\n" +
                        "                                                <span class=\"icon-star text-warning\"></span>\n" +
                        "                                                <span class=\"icon-star-half-full text-warning\"></span>\n" +
                        "                                                <span class=\"review\">(1302 Reviews)</span>\n" +
                        "                                            </p>\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
                        "                                </a>\n" +
                        "                                <hr></hr>\n" +
                        "                            </div>");
            }
            writer.append(numberPage+"");
        }
    }
//     <img src=\'"+c.getLstImg().get(0).getUrl()+"\' style=\"width: 100%;height:100%/>
}
