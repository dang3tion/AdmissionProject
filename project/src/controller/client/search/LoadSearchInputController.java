package controller.client.search;

import dao.impl.SearchDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/search-major", name = "search-major")
public class LoadSearchInputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        SearchDAO dao = new SearchDAO();
        ArrayList<String> majors = dao.loadMajors();

        PrintWriter writer = resp.getWriter();

        for (String s : majors){
            writer.println("<option value = "+s+">"+s+"</option>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
