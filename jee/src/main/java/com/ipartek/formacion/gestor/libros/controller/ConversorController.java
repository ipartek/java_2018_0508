package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/convertir")

public class ConversorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final double PIES_METRO = 3.2808;
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			double valor = new Double(request.getParameter("valor"));

			String tipo = request.getParameter("tipo");
			double resultado = 0.0;

			if ("m".equals(tipo)) {
				resultado = valor * PIES_METRO;
			} else {
				resultado = valor / PIES_METRO;
			}
			request.setAttribute("resultado", resultado);
			request.getRequestDispatcher("conversor.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			
		} finally {
			
		}

	}
}
