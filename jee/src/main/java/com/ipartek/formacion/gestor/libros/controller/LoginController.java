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

	private RequestDispatcher dispatch = null;
	private static final String VIEW_CORRECTA = "saludo.jsp";
	private static final String VIEW_FALLO = "login.jsp";

	private static String MSG = " ";

	private static final String USUARIO = "admin";
	private static final String PASS = "12345";

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

		try {

			dispatch = request.getRequestDispatcher(VIEW_FALLO);

			String usuForm = request.getParameter("usuario");
			String passForm = request.getParameter("password");

			if (usuForm == null) {
				if (USUARIO.equals(usuForm) && PASS.equals(passForm)) {
					dispatch = request.getRequestDispatcher(VIEW_CORRECTA);
					request.setAttribute("usuario", usuForm);
				} else {
					MSG = "Has introducido el usuario o la contraseña mal";
					request.setAttribute("msg", MSG);
				}
			}

		} catch (NumberFormatException e) {
			// e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
			MSG = "Hemos tenido un problema tecnico.";
			request.setAttribute("msg", MSG);
		} finally {

			dispatch.forward(request, response);

		}

	}
}
