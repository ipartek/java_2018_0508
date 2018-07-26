package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static  final String USUARIO_CORRECT = "admin";
	private static  final String PASSWORD_CORRECT = "admin1234";
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String usu = request.getParameter("usu");
		String pass = request.getParameter("pass");
		
		

		if (pass.equals(PASSWORD_CORRECT)&& usu.equals(USUARIO_CORRECT)) {

			out.print("Bienvenida, " + usu);

			HttpSession session = request.getSession();
			session.setAttribute("usu", usu);
		}else {
			
			out.print("Lo sentimos el Usuario o contraseña es incorrecta!");  
            request.getRequestDispatcher("login.jsp").include(request, response);  
		}

	}

}
