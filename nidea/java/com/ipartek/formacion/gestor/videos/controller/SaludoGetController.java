package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saludoGet")
public class SaludoGetController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG = Logger.getLogger(PrestamosController.class.getName());
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Pasamos por doGet()");
		

		String nombre = (String) request.getParameter("nombre");
		String apellido1 = (String) request.getParameter("apellido1");
		String apellido2 = (String) request.getParameter("apellido2");
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido1", apellido1);
		request.setAttribute("apellido2", apellido2);
		
		
		request.getRequestDispatcher("saludo.jsp").forward(request, response);
	}
	
}
