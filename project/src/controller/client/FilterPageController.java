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

        String params[] = {"All","All","daihoc"};
        ArrayList<CollegesInfo> list = dao.getList(params,1);
        req.setAttribute("list",list);

        int numberPage = dao.getNumberPage();
        req.setAttribute("numberPage",numberPage);


        System.out.println(numberPage);

        req.getRequestDispatcher("view/jsp/page/FilterUI.jsp?page=1&province="+params[0]+"&major="+params[1]+"&type="+params[2]).forward(req,resp);

    }

}
