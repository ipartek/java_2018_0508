package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.filtro.LoginFiltro;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(LoginFiltro.class);
	private static final String VIEW_LOGIN = "login.jsp";

	private static final String USER = "admin";
	private static final String PASS = "admin";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		HttpSession session = request.getSession();
		boolean acceso=false;
		String view=VIEW_LOGIN;
		try {

			// recoger parametros
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");

			if (USER.equals(user) && PASS.equals(pass)) {
				acceso=true;
				session.setAttribute("acceso", acceso);
				session.setMaxInactiveInterval(60); // 1min
				

			} else {
				acceso=false;
				session.setAttribute("acceso", acceso);
				view=VIEW_LOGIN;
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("upsss...algo salió mal");
		} finally {
			request.setAttribute("acceso", acceso);
			request.getRequestDispatcher(view).forward(request, response);

		}
	}

}
