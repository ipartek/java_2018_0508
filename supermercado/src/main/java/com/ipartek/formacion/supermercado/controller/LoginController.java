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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		try {
			
			String nombre = request.getParameter("correo");
			String pass = request.getParameter("pass");
			
			Usuario u = (Usuario) session.getAttribute("usuario");
			if("admin".equals(nombre) && "12345678".equals(pass)) {

				if (u == null) {
					u = new Usuario();
					u.setNombre(nombre);
					u.setContrasenya(pass);
					session.setAttribute("usuario", u);
					response.sendRedirect(request.getContextPath() + "/privado/listado.jsp");
				}
			}else {
				response.sendRedirect(request.getContextPath() + "/login.jsp?msg=Usuario%20o%20Pass%20Incorrectos");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
