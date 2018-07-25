package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int INTENTOS = 7;
	private static final String PALABRA = "cesar";

	private String palabraUsuario = "_______";
	private int contador = 0;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String let = request.getParameter("let");

		if (let != null && !let.trim().equals("") && let.length() == 1) {

			if (contador < INTENTOS) {
				contador++;
				for (int i = 0; i < PALABRA.length(); i++) {
					if (PALABRA.toLowerCase().charAt(i) == let.toLowerCase().charAt(0)) {
						palabraUsuario = palabraUsuario.substring(0, i) + let + palabraUsuario.substring(i + 1);

					}
				}

				request.setAttribute("respuesta", palabraUsuario);
				request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
			} else {
				request.setAttribute("respuesta", "Game Over");
				request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
			}

		}

	}
}
