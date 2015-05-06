package com.sds.icto.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.dao.EmailListDAO;
import com.sds.icto.vo.EmailListVO;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignInServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EmailListDAO dao = new EmailListDAO();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String fn = request.getParameter("fn");
		String ln = request.getParameter("ln");
		String email = request.getParameter("email");

		dao.insert(new EmailListVO(0, fn, ln, email));

		request.setAttribute("fn", fn);
		request.setAttribute("ln", ln);
		request.setAttribute("email", email);

		request.getRequestDispatcher("show_emaillist.jsp").forward(request,
				response);

	}

}
