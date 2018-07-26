package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW_LOGIN = "login.jsp";
	private static final String VIEW_SALUDO = "saludo.jsp";
	private static final String USER = "admin";
	private static final String PSWD = "1234";

	private RequestDispatcher dispatch = null;
	// parametros
	private static String user = "";
	private static String pswd = "";
	// atributos
	private static String msg = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		msg = "";
		try {
			dispatch = request.getRequestDispatcher(VIEW_LOGIN);

			user = request.getParameter("user");
			pswd = request.getParameter("pswd");

			if (user != null || pswd != null) {
				if (user.equals(USER) && pswd.equals(PSWD)) {
					dispatch = request.getRequestDispatcher(VIEW_SALUDO);
				} else {
					msg = "Lo sentimos pero las credenciales no son correctas. Inténtelo de nuevo.";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Error en la llamada.";
		} finally {
			request.setAttribute("user", user);
			request.setAttribute("msg", msg);
			dispatch.forward(request, response);
		}
	}
}
