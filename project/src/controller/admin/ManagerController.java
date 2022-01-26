package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.impl.CollegesBO;
import bo.impl.CourseBO;
import bo.impl.FrameBO;
import model.Course;
import model.TrainingFrame;

@WebServlet("/admin/additional")
public class ManagerController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		  response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Course> lstCourse = CourseBO.getInstance().getCourses();
		List<TrainingFrame> lstFrame = FrameBO.getInstance().getListFrame();
		request.setAttribute("lstFrame", lstFrame);
		request.setAttribute("lstCourse", lstCourse);
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/view/jsp/page/AdditionalUI.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("id") != null) {

			System.out.println(request.getParameter("id"));
			boolean isExists = CollegesBO.getInstance().isIdExists(request.getParameter("id"));

			response.getOutputStream().print(isExists);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} else {
			if (request.getParameter("confirm-add") != null) {
				boolean success = CollegesBO.getInstance().createNewObject(request);
				if (success) {
					System.out.println(request.getContextPath());
					request.getSession().setAttribute("msg", "Thêm thông tin trường mới thành công");
					response.sendRedirect(request.getContextPath() + "/admin");
				} else {
					request.setAttribute("msg", "Thêm thông tin không thành công");
					doGet(request, response);
				}
			}
		}
	}

}
