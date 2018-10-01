package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegistroUsuarioController
 */
@WebServlet("/registro")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String codigo = request.getParameter("nombre");
			String nombre = request.getParameter("password");
			String passwordRepit = request.getParameter("passwordRepit");
			
			
			
			
					
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
