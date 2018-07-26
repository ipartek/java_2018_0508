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

	private static final String VIEW_LOGIN = "login.jsp";
	private static final String VIEW_SALUDO = "saludo.jsp";
	private static String msg = "";
	private static String usuario = "";
	private static String contrasena = "";
	private static final String USUARIO_REG = "admin";
	private static final String CONTRASEÑA_REG = "1234";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			msg="";
			dispatch = request.getRequestDispatcher(VIEW_LOGIN);

			usuario = request.getParameter("usuario");
			contrasena = request.getParameter("contrasena");
			if (usuario != null) {
				if (usuario.equals(USUARIO_REG) && contrasena.equals(CONTRASEÑA_REG)) {
					request.setAttribute("msg", "Hola " + usuario + " bienvenido!!");
					request.setAttribute("nombreCompleto", usuario);
					dispatch = request.getRequestDispatcher(VIEW_SALUDO);

				} else {
					msg = "usuario o contraseña incorrecta.";
				}
			}

		} catch (Exception e) {
			msg = "Ha ocurrido un error=>" + e.getMessage();
		} finally {
			request.setAttribute("msg", msg);
			dispatch.forward(request, response);

		}

	}

}
