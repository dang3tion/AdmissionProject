package controller.client.search;

import dao.impl.SearchDAO;
import model.CollegesInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

@WebServlet(urlPatterns = "/search", name = "search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String keyword =  req.getParameter("keyword");

        SearchDAO dao = new SearchDAO();
        ArrayList<CollegesInfo> list = dao.getList(keyword);
        req.setAttribute("list",list);

        System.out.println(list);

        req.getRequestDispatcher("view/jsp/page/SearchUI.jsp?page="+1).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
