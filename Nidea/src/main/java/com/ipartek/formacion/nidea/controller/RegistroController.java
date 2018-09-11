package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/login")
public class RegistroController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String mail;
	private String psw;
       
 
    public RegistroController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getParameters(request, response);
	}

	private void getParameters(HttpServletRequest request, HttpServletResponse response) {
		
		nombre = request.getParameter("nombre");
		nombre += request.getParameter("apellido");
		
		mail = request.getParameter("mail");
		psw = request.getParameter("psw");
	
	}

}
