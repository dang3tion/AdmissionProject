package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin")
public class AdminUI extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sess = request.getSession();
		if (sess.getAttribute("token") != null) {
			if (request.getSession().getAttribute("msg") != null) {
				request.getSession().removeAttribute("msg");
				request.setAttribute("msg", "true");
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/view/jsp/page/AdminUI.jsp");
				dispatcher.forward(request, response);
			} else {
				sess.removeAttribute("token");
				response.sendRedirect(request.getContextPath());
			}
		} else {
			sess.setAttribute("token", "token");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/jsp/page/AdminUI.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
