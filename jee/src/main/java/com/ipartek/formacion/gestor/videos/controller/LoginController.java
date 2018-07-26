package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inicia-sesion")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final static String USUARIO_AMIN = "Admin";
	private final static String ADMIN_PASSWORD = "1234";

	private static final String MSG_ERROR_INESPERADO = "Ha ocurrido un error inesperado. Por favor, vuelve a intentarlo";
	private static final String MSG_ERROR_USUARIO = "El usuario o la contraseña introducidas no son correctas.";

	private static boolean esComienzo = true;
	private static String usuario;
	private static String password;
	private static String msg;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		esComienzo = false;
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			usuario = request.getParameter("usuario");
			password = request.getParameter("psw");

			if (!esComienzo) {

				if (usuario != null) {

					if (USUARIO_AMIN.equalsIgnoreCase(usuario)) { // Usuario administrador

						if (ADMIN_PASSWORD.equals(password)) { // Contraseña administrador

							msg = "Bienvenido/a " + usuario;

							// Enviamos el saludo al formulario.
							request.setAttribute("msg", msg);

							request.getRequestDispatcher("saludo.jsp").forward(request, response);

						} 

					} 
					msg = MSG_ERROR_USUARIO;

				} 
			
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} catch (Exception e) {
			
			msg = MSG_ERROR_INESPERADO;
		}

	}

}
