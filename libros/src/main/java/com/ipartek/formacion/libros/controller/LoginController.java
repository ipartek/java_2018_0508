package com.ipartek.formacion.libros.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libros.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VISTA_PRINCIPAL = "backoffice/prestamos";
	public static final String VISTA_FALLIDA = "login.jsp";

	public static final String USUARIO_ADMIN = "admin";
	public static final String USUARIO_PASSWORD = "admin";

	public static Alert alert;
	String vista;
	String nombre;
	String password;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			getParameters(request);
			checkUser(request);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(vista);

		}

	}

	private void checkUser(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (nombre != null && password != null) {

			if (USUARIO_ADMIN.equals(nombre) && USUARIO_PASSWORD.equals(password)) {

				vista = VISTA_PRINCIPAL;
				session.setAttribute("usuario", nombre);
				alert = new Alert(Alert.SUCCESS, "Bienvenido " + nombre);

			} else {

				vista = VISTA_FALLIDA;
				alert = new Alert(Alert.DANGER, "Usuario incorrecto ");

			}
		}else {
			alert = new Alert(Alert.DANGER, "Usuario incorrecto ");
		}

	}

	private void getParameters(HttpServletRequest request) {
		
		nombre = request.getParameter("nombreUsuario");
		password = request.getParameter("password");

	}

}
