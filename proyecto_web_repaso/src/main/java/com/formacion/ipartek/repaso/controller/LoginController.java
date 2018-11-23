package com.formacion.ipartek.repaso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.formacion.ipartek.repaso.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Logger
	private final static Logger LOG = Logger.getLogger(LoginController.class);

	private final static String VIEW_LOGIN = "login.jsp";
	private final static String VIEW_PRIVADO = "privado/privado.jsp";

	private static String view = "";
	private Alert alert = null;

	private static final String USER = "admin";
	private static final String PSWD = "admin";

	private String usuario = "";
	private String pass = "";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		view = "";
		try {
			usuario = request.getParameter("usuario");
			pass = request.getParameter("pass");

			if (usuario.equals(USER) && pass.equals(PSWD)) {
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario);
				session.setAttribute("pass", pass);
				session.setMaxInactiveInterval(60 * 60); // 1 hora

				alert = new Alert(Alert.ALERT_SUCCESS, "Bienvenido " + usuario + "!!");
				view = VIEW_PRIVADO;
			} else {
				view = VIEW_LOGIN;
				alert = new Alert(Alert.ALERT_WARNING, "Credenciales incorrectas");
			}
			request.setAttribute("alert", alert);
		} catch (Exception e) {
			LOG.error(e);
			view = VIEW_LOGIN;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		} finally {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
