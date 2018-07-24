package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")

public class ahorcadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String palabra = "Cesar";

	private static char[] huecos = { '_', '_', '_', '_', '_' };

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1.- Recibir Parametros

			// 2.- Validar Parametros

			// 3.- LLamar modelo DAO

			// 4.- Enviar atributos a la vista

			request.setAttribute("huecos", huecos);

			// 5.- Ir a la vista

			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1.- Recibir Parametros

			char c = (char) request.getAttribute("letra");
			
			System.out.println(c);

			// 2.- Validar Parametros

			for (int i = 0; i < palabra.length(); i++) {
				if (c == palabra.charAt(i)) {
					huecos[i] = c;
					break;
				}
			}

			// 3.- LLamar modelo DAO

			// 4.- Enviar atributos a la vista

			request.setAttribute("huecos", huecos);

			// 5.- Ir a la vista

			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
