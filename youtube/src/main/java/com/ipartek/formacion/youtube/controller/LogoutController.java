package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			// invalidar la sesion del usuario
			HttpSession sesionActual = request.getSession();
			if (sesionActual != null) {
				sesionActual.invalidate();
				sesionActual.removeAttribute("usuario");
				sesionActual = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			response.sendRedirect(request.getContextPath() + "/inicio");
		}

	}

}
