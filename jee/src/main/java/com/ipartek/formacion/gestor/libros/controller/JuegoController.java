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
@WebServlet("/juego")
public class JuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;

	private static final String VIEW_INDEX = "index.jsp";
	private static final String palabra="cesar";
	char[] respuesta;
	
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Pasamos por juego");

		// 1. recibir parametros
		String letra = request.getParameter("letra");
		
		// 2. validar parametros

		// 3. llamar modelo DAO

		// 4. enviar Atributos vista
		String palabra = String.format("Palabra %s", letra);
		
		request.setAttribute("palabra", palabra);

		// 5. ir a la vista
		request.getRequestDispatcher("juego.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		char c=' ';
		boolean contador=true;
		try {
			dispatch= request.getRequestDispatcher(VIEW_INDEX);
			String letra = request.getParameter("letra");
					if (letra != null) {
						
						if(palabra.toLowerCase().contains(letra)) {
							request.setAttribute("msg", "Letra correcta");
							c = (char) request.getParameter("letra").toLowerCase().charAt(0);
							for (int i = 0; i < palabra.length(); i++) {
								if (c == palabra.charAt(i)) {
									respuesta[i] = c;
									contador=true;
									break;
								}
							}
							request.getRequestDispatcher("juego.jsp").forward(request, response);
						}else {
							
							request.setAttribute("msg", "Letra incorrecta");
							request.getRequestDispatcher("juego.jsp").forward(request, response);
						}
				
				} else {
	
					request.setAttribute("msg", "Por favor introduce una letra");
					request.getRequestDispatcher("juego.jsp").forward(request, response);
				}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dispatch.forward(request, response);
		}
	}

}
