package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saludo
 */
@WebServlet("/saludo")
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Pasamos por saludo GET");
		
		//1. recibir parametros
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		
		//2. validar parametros
				
		//3. llamar modelo DAO
				
		//4. enviar Atributos vista
		String nombreCompleto = String.format("%s %s %s", nombre, apellido1, apellido2);
		request.setAttribute("nombreCompleto", nombreCompleto);
		
		//5. ir a la vista
		request.getRequestDispatcher("saludo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//TODO No funciona con POST
		System.out.println("Pasamos por saludo POST");
		
		try {
			//1. recibir parametros
			String nombre = request.getParameter("nombre");
			String apellido1 = request.getParameter("apellido1");
			String apellido2 = request.getParameter("apellido2");
			
			//2. validar parametros
			boolean datosCorrectos = true;
			if(nombre.equals(null) || !"".equals(nombre.trim())) {
				datosCorrectos = false;
			}else if(apellido1.equals(null) || !"".equals(apellido1.trim())) {
				datosCorrectos = false;
			}else if(apellido2.equals(null) || !"".equals(apellido2.trim())) {
				datosCorrectos = false;
			}
			
			//3. llamar modelo DAO
					
			//4. enviar Atributos vista
			String nombreCompleto = String.format("%s %s %s", nombre, apellido1, apellido2);
			
			//5. ir a la vista
			if(datosCorrectos == true) {
				request.setAttribute("nombreCompleto", nombreCompleto);
				request.getRequestDispatcher("saludo.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "Por favor Rellena los datos y no seas vaguete.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

}
