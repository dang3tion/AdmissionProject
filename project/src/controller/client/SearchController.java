package controller.client;

import dao.impl.SearchDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/search", name = "search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String keyword =  req.getParameter("keyword");

        SearchDAO dao = new SearchDAO();
        ArrayList<String> hints = dao.getHint(keyword);
        req.setAttribute("hints",hints);


        PrintWriter writer = resp.getWriter();
//        resp.sendRedirect("view/jsp/page/IndexUI.jsp");

        for (String s : hints){
            writer.println(
                    "<a onClick=\"clickOnItem("+"'"+s+"'"+");\" style=\"text-align:left;\" href=\"#\" class=\"list-group-item\">"+s+"</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
