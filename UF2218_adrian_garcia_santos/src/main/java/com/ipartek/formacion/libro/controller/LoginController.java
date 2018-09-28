package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libro.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vista = "login.jsp";
		
		try {
			String nombreUsuario = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			
			if("William".equals(nombreUsuario) && "Shakespeare".equals(pass) || 
					"cervantes".equals(nombreUsuario) && "saavedra".equals(pass) || 
					"pablo".equals(nombreUsuario) && "neruda".equals(pass) || 
					"paulo".equals(nombreUsuario) && "cohelo".equals(pass)) {
				
				
				HttpSession session = request.getSession();
				
				Usuario u = new Usuario(nombreUsuario, pass);
				
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60 * 60 * 24); //1 día
				
				vista = "home.jsp";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			request.getRequestDispatcher("home").forward(request, response);
		}
		
	}

}
