package com.ipartek.formacion.repaso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(LoginController.class);    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String msgLogin = "";
		
		try {
			
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			
			if("admin".equals(nombre.trim()) && "admin".equals(pass.trim())) {
				
				session.setAttribute("login", true);
				msgLogin = "Sesión iniciada!";
			
			}else {
				msgLogin = "Datos incorrectos";
			}
			
			request.setAttribute("msgLogin", msgLogin);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
	}

}
