package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor")
public class ConversorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static double resultado;
	private static double pies = 0;
	private static double metros;
	private static double conversordePies = 0.3048;

	private RequestDispatcher dispatch = null;
	private static final String VIEW = "conversor.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);// Porque recibimos los conversores por post

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);// Porque aterrizamos en conversor.jsp por get
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramPies = "";
		String paramMetros = "";
		try {
			// TODA LA EXTRUCTURA
			dispatch = request.getRequestDispatcher(VIEW);
			int formulario = Integer.parseInt(request.getParameter("formulario"));

			// CONVERSOR DE PIES A METROS
			if (formulario == 1) {
				paramPies = request.getParameter("pies");
				pies = Double.parseDouble(paramPies);
				resultado = pies * conversordePies;
				request.setAttribute("metros", resultado);

			// CONVERSOR DE METROS A PIES
			} else if (formulario == 2) {
				paramMetros = request.getParameter("metros");
				metros = Double.parseDouble(paramMetros);
				resultado = metros / conversordePies;
				request.setAttribute("pies", resultado);
			}
		
		}catch (NumberFormatException e) {
			if (e.getMessage().contains("empty String")) {
				request.setAttribute("msg","introduce un numero por favor");
			} else {
				request.setAttribute("msg","Solo se aceptan numeros");
			}
		
		} catch (Exception e) {
			
		} finally {
			dispatch.forward(request, response);
		}

	}

}
