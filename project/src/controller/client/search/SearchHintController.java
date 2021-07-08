package controller.client.search;

import dao.impl.SearchDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@WebServlet(urlPatterns = "/search-hint", name = "search-hint")
public class SearchHintController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String keyword =  req.getParameter("keyword");

        SearchDAO dao = new SearchDAO();
        HashSet<String> hints = dao.getHint(keyword);
        req.setAttribute("hints",hints);


        PrintWriter writer = resp.getWriter();
//        resp.sendRedirect("view/jsp/page/IndexUI.jsp");

        for (String s : hints){
            writer.println(
                    "<a onClick=\"clickOnItem("+"'"+s+"'"+");\" onchange=\"onChangeItem("+"'"+s+"'"+");\" style=\"text-align:left;\" href=\"#\" class=\"list-group-item\">"+s+"</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
