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
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Pasamos por saludo");
		
		//1. recibir parametros
		String nombre = request.getParameter("nombre");
		String ap1 = request.getParameter("Otilio");
		String ap2 = request.getParameter("Gomez");
		
		//2. validar parametros
				
		//3. llamar modelo DAO
				
		//4. enviar Atributos vista
		String nombreCompleto= String.format("nombre completo %s %s  %s",nombre,ap1,ap2);
		request.setAttribute("nombreCompleto",nombreCompleto);
				
		//5. ir a la vista
		request.getRequestDispatcher("saludo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nom");
		
		if(nombre!= null && "".equals(nombre.trim())) {
			request.setAttribute("nombreCompleto",nombre + " envio por POST");
			request.getRequestDispatcher("saludo.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg","Por favor rellena el nombre");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
