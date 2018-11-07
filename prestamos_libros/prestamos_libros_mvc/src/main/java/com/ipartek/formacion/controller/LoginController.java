package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		doProcess(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		
		HttpSession session = request.getSession();
		
		try {
			String usuario = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			
			if("admin".equals(usuario) && "admin".equals(pass)) {
				
				session.setAttribute("usuario", usuario);
				session.setAttribute("pass",pass);
				request.getRequestDispatcher("editoriales").forward(request, response);
				
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
