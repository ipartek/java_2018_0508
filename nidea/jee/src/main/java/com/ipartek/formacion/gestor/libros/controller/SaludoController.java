package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saludo")

public class SaludoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG = Logger.getLogger(PrestamosContoller.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("pasamos por doGet");

		// 1.Recibir para metros
		
		String nombre = (String)request.getParameter("nombre");
		String ape1 = (String)request.getParameter("ape1");
		String ape2 = (String)request.getParameter("ape2");




		// 2.Validar parametros

		// 3.llamar modelo

		// 4.enviar Atributos vista
	String nombreCompleto = String.format("nombre completo %s %s %s", nombre, ape1, ape2);
	request.setAttribute("nombreCompleto",nombreCompleto);
	

		// 5.Ir a la vista
		
		request.getRequestDispatcher("saludo.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		 String nombre = request.getParameter("nom");
		 
		 if(nombre != null && !"".equals(nombre.trim())) {
			 request.setAttribute("nombreCompleto", nombre + "envio por POST");
			 request.getRequestDispatcher("saludo.jsp").forward(request, response);
		 }else {
			 request.setAttribute("msg", "por favor rellena los datos");
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		 }
		
	}

}
