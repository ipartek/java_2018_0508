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

//	private static final Logger LOG = Logger.getLogger(name);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.- Recibir Parametros

		String nombre = (String) request.getParameter("nombre");
		String ap1 = (String) request.getParameter("ap1");
		String ap2 = (String) request.getParameter("ap2");

		// 2.- Validar Parametros

		// 3.- LLamar modelo DAO

		// 4.- Enviar atributos a la vista

		request.setAttribute("nombre", nombre);
		request.setAttribute("ap1", ap1);
		request.setAttribute("ap2", ap2);

		// 5.- Ir a la vista

		request.getRequestDispatcher("saludo.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.- Recibir Parametros

		String nombre = (String) request.getParameter("nombre");
		String ap1 = (String) request.getParameter("ap1");
		String ap2 = (String) request.getParameter("ap2");

		// 2.- Validar Parametros

		// 3.- LLamar modelo DAO

		// 4.- Enviar atributos a la vista

		request.setAttribute("nombre", nombre);
		request.setAttribute("ap1", ap1);
		request.setAttribute("ap2", ap2);

		// 5.- Ir a la vista

		if (nombre==null || "".equals(nombre.trim())) {
			request.setAttribute("msg", "Rellena el nombre, no seas un vaguete");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("saludo.jsp").forward(request, response);
		}
		
	}
}
