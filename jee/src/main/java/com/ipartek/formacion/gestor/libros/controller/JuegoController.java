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
@WebServlet("/juego")
public class JuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String palabra = "cesar";

	private static char[] respuesta = { '_', '_', '_', '_', '_' };
	
	private static int VIDAS = 0;
	private static final int MAX_VIDAS = 6;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1.- Recibir Parametros

			// 2.- Validar Parametros

			// 3.- LLamar modelo DAO

			// 4.- Enviar atributos a la vista

			request.setAttribute("respuesta", respuesta);

			// 5.- Ir a la vista

			request.getRequestDispatcher("juego.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		char c = ' '; 
		boolean contador = false;
		
		try {
			// 1.- Recibir Parametros
			c = (char) request.getParameter("letra").toLowerCase().charAt(0);

			// 2.- Validar Parametros

			for (int i = 0; i < palabra.length(); i++) {
				if (c == palabra.charAt(i)) {
					respuesta[i] = c;
					contador=true;
					break;
				}
			}
			
			boolean fin = false;
			
			if (!contador) {
				VIDAS++;
			}else {
				fin = solucion();
			}
			
			// 3.- LLamar modelo DAO

			// 4.- Enviar atributos a la vista

			
			if (fin) {
				request.setAttribute("msg", "Zorionak !!! Has ganado");
			}else if(VIDAS == MAX_VIDAS){
				request.setAttribute("msg", "Vaya... no has ganado, otra partidita");
			}
			
			request.setAttribute("resultado", respuesta);
			request.setAttribute("vidas", VIDAS);

			// 5.- Ir a la vista

			request.getRequestDispatcher("juego.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private boolean solucion() {
		
		boolean resul = true;
		
		for (int i = 0; i < respuesta.length; i++) {
			if (respuesta[i] == '_') {
				resul = false;
			}
		}
		
		return resul;
		
	}
}