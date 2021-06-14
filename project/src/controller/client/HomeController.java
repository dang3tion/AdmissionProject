package controller.client;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ICollegesBO;
import bo.ICourseBO;
import bo.impl.CollegesBO;
import bo.impl.CourseBO;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	private ICourseBO courseBO = CourseBO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
		
	    req.setAttribute("courses", courseBO.getCourses());;
		req.getRequestDispatcher("view/indexUI.jsp").forward(req, resp);
	}
}