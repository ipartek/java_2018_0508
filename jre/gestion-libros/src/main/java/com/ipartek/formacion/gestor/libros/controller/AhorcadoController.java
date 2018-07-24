package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AhorcadoController
 */
@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private String palabra = "cesar";
	private String[] respuesta = new String[palabra.length()];
	private static final String VIEW_AHORCADO = "ahorcado.jsp";
	private int cont = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(VIEW_AHORCADO).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. recibir parametros
		String letra = request.getParameter("letra");

		// 2. validar parametros
		if (letra != null) {
			for (int i = 0; i < palabra.length(); i++) {
				if (palabra.charAt(i) == letra.charAt(0)) {
					// 4. enviar Atributos vista
					respuesta[i] = letra;
					request.setAttribute("letra", "la letra " + letra + " se encuentra en la palabra");
					request.setAttribute("respuesta", respuesta);
					break;
				}
			}
		} else {
			cont++;
			request.setAttribute("letra", "la letra " + letra + " no se encuentra en la palabra");
			request.setAttribute("respuesta", respuesta);
			request.setAttribute("contador", cont);

		}

		// 5. ir a la vista
		request.getRequestDispatcher(VIEW_AHORCADO).forward(request, response);
	}

}
