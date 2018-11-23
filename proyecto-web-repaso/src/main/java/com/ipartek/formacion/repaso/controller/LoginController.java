package com.ipartek.formacion.repaso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LoginController.class);

	private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_PRIVADO = "backoffice/backoffice.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String view = VIEW_INDEX;

		try {

			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");

			if ("admin".equals(usuario) && "admin".equals(password)) {
				session.setAttribute("usuario", usuario);
				session.setMaxInactiveInterval(60 * 5); // 5min
				view = VIEW_PRIVADO;
			} else {
				view = VIEW_INDEX;
				request.setAttribute("fallo", "Introduce las credenciales bien por favor");
			}

		} catch (Exception e) {
			LOG.error(e);
		} finally {
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}
