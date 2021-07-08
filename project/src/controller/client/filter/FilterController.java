package controller.client.filter;

import dao.impl.FilterDAO;
import model.CollegesInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (urlPatterns = "/filter", name = "filter")
public class FilterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String province = req.getParameter("province");
        String major = req.getParameter("major");
        String type = req.getParameter("type");

        String[] params = {province,major,type};
        filter(params,req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    private void filter(String[] type,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FilterDAO dao = new FilterDAO();
        ArrayList<String> majors = dao.loadMajors();

        int page = Integer.parseInt(req.getParameter("page"));

        req.setAttribute("majors",majors);

        ArrayList<CollegesInfo> list = dao.filter(type,page);
        req.setAttribute("list",list);

        int numberPage = dao.getNumberPage();
        req.setAttribute("numberPage",numberPage);


        req.getRequestDispatcher("view/jsp/page/FilterUI.jsp?page="+1).forward(req,resp);

    }
}
