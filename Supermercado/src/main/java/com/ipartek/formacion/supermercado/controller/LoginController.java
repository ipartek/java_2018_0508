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
 * Servlet implementation class LogInController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String user = "";
	private String pswd = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		try {
			
			user = request.getParameter("user");
			pswd = request.getParameter("pswd");
			
			if(user.equals("admin@admin.com") && pswd.equals("admin123")){
				
				Usuario u = new Usuario(user, pswd);
				
				//Guardar Usuario en session
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60); //1 minuto
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}finally {
			response.sendRedirect(request.getContextPath() + "/home");
//			request.getRequestDispatcher("home.jsp").forward(request, response);
		}			
	}

}
