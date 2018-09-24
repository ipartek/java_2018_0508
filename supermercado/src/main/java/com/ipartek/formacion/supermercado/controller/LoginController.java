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
		
		HttpSession session=request.getSession();		
		String msg="";
		try {
			String nombre = request.getParameter("correo");
			String pass = request.getParameter("pass");
			if("admin".equals(nombre) && "admin".equals(pass)) {
				session.setAttribute("usuario", new Usuario(nombre,pass));	
				msg = "Usuario logeado correctamente";
			}else {
				msg = "Usuario incorrecto";
			}
			
				
		} catch (Exception e) {
			
		}finally {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
