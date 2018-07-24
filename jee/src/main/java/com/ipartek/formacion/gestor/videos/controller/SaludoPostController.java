package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saludoPost")
public class SaludoPostController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Pasamos por doPost()");

		// 1. Recibir parámetros
		String nombre = (String) request.getParameter("nombre");

		// 2. Validar parámetros
		if (nombre == null) {

			request.setAttribute("msg", "Por favor rellena el nombre y no seas vago.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} else if (!nombre.trim().isEmpty()) {
			request.setAttribute("nombre", nombre);
		}

		// 4. Enviar atributos a la Vista
		request.getRequestDispatcher("saludo.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Pasamos por doGet()");

		String nombre = (String) request.getParameter("nombre");

		request.setAttribute("nombre", nombre);

		request.getRequestDispatcher("saludo.jsp").forward(request, response);
	}

}
