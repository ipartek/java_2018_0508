package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER = "admin";
	private static final String PASS = "admin";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String view = "login.jsp";
		String msg = "Error%20inesperado";
		try {
			String nombre = request.getParameter("correo");
			String pass = request.getParameter("pass");
			if (USER.equals(nombre) && PASS.equals(pass)) {
				
				session.setAttribute("usuario", new Usuario(nombre, pass));
				session.setMaxInactiveInterval(60); // session  expira en 1 min
				msg = "Usuario%20logeado%20correctamente";
				view = "listado";
				
				
			} else {
				msg = "Usuario%20incorrecto";
				
			}
			
			request.setAttribute("msg", msg);

		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			
			response.sendRedirect(view+"?msg="+msg);
			//request.getRequestDispatcher(view).forward(request, response);
		}
			


		

	}

}
