package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet para gestionar cuando un usuario abandona la aplicación.
 */
@WebServlet("/logout")
public class LogOutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession();
			
			if (session != null) {
				session.invalidate();	// Invalidar la sesión del usuario
				session = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("inicio").forward(request, response);
		}
	}

}
