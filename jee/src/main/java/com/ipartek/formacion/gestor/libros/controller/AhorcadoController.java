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
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String letra = request.getParameter("let");

		if (letra != null && !"".equals(letra.trim())) {
			request.setAttribute("Tu respuesta ingresada es : ", letra);
			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "por favor rellena los datos");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
}
