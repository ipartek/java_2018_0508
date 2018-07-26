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
	private static final String VIEW = "login.jsp";
	private static final String VIEW_SALUDO = "saludo.jsp";

	private static String usuario = "";
	private static String password = "";
	
	private static final String USUARIO_CORRECTO="admin";
	private static final String PASSWORD_CORRECTO="1234";
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			usuario = request.getParameter("usuario");
			password = request.getParameter("password");
			dispatch = request.getRequestDispatcher(VIEW);

			if (usuario.isEmpty() || password.isEmpty()) {
				request.setAttribute("msg", "Hay campos vacios");

			} else {
				if (!usuario.equalsIgnoreCase(USUARIO_CORRECTO)) {
					request.setAttribute("msg", "Los credenciales no son correctos");
					request.getRequestDispatcher(VIEW).forward(request, response);
				} else {
					if (!password.equals(PASSWORD_CORRECTO)) {
						request.setAttribute("msg", "Los credenciales no son correctos");
						dispatch.forward(request, response);
					} else {
						request.setAttribute("nombreCompleto", usuario);
						request.getRequestDispatcher(VIEW_SALUDO).forward(request, response);
					}

				}
			}

		} catch (Exception e) {
			request.setAttribute("msg", "Ha surgido un problema");
		} finally {
			request.setAttribute("usuario", usuario);
			request.setAttribute("password", password);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}

	}

}
