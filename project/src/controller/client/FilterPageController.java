package controller.client;

import dao.impl.FilterDAO;
import model.CollegesInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/filterpage", name = "filterpage")
public class FilterPageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FilterDAO dao = new FilterDAO();
        ArrayList<String> majors = dao.loadMajors();

        req.setAttribute("majors",majors);

        String params[] = {"tphcm",majors.get(1),"daihoc"};
        ArrayList<CollegesInfo> list = dao.getList(params);
        req.setAttribute("list",list);

        req.getRequestDispatcher("view/jsp/page/FilterUI.jsp").forward(req,resp);

    }

}
