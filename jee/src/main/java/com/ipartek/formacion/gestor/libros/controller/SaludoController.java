package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	
	private RequestDispatcher dispatch = null;
	private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_SALUDO = "saludo.jsp";
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Pasamos por saludo");
		
		//1. recibir parametros
		String nombre = request.getParameter("nombre");
		String ape1 = request.getParameter("ape1");
		String ape2 = request.getParameter("ape2");
		
		//2. validar parametros
				
		//3. llamar modelo DAO
				
		//4. enviar Atributos vista
		String nombreCompleto = String.format("nombre completo %s %s %s", nombre, ape1, ape2);
		request.setAttribute("nombreCompleto", nombreCompleto);		
		
		//5. ir a la vista
		request.getRequestDispatcher("saludo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			dispatch = request.getRequestDispatcher(VIEW_INDEX);
			
			String nombre = request.getParameter("nom");
			
			if ( nombre != null && !"".equals(nombre.trim())) {
				
				request.setAttribute("nombreCompleto", nombre + " envio por POST");
				dispatch = request.getRequestDispatcher(VIEW_SALUDO);
			}else {
				
				request.setAttribute("msg","Por Favor Rellena el nombre y no seas vagete"); 
				
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			dispatch.forward(request, response);
		}	
		
		
		
	}

}
