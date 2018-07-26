package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USUARIO_CORRECTO = "admin";
	private static final String PASS_CORRECTO = "1234";
	private static final String LOGIN_PATH = "saludo.jsp";
	private static final String ERROR_PATH = "login.jsp";
	private static final String ERROR_MSG = "Las credenciales no son correctas.";

	// parametros (lo que recibo del jsp)
	private String usuario = "";
	private String password = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		try {
			usuario = request.getParameter("usuario");
			password = request.getParameter("pass");

			if (usuario != null && password != null) {
				if (usuario.equals(USUARIO_CORRECTO) && password.equals(PASS_CORRECTO)) {
					request.setAttribute("nombreCompleto", usuario);
					request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
				} else {
					request.setAttribute("msg", ERROR_MSG);
					request.getRequestDispatcher(ERROR_PATH).forward(request, response);
				}
			} else {
				request.getRequestDispatcher(ERROR_PATH).forward(request, response);
			}

		} catch (NullPointerException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				request.setAttribute("msg", msg);
				request.getRequestDispatcher(ERROR_PATH).forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("msg", "");

		}

	}

}
