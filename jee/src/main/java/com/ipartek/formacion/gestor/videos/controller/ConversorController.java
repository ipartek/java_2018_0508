package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/convertir")
public class ConversorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final float PIE = 3.28084f;
	public static final float PULGADA = 39.370f;

	private static String msg;
	private static float num;
	private static String unidad;

	private static float resultado;
	private static boolean esComienzo;

	public ConversorController() {

		inicializarConversor();
	}

	private void inicializarConversor() {

		msg = "";
		num = 0;
		resultado = 0;
		esComienzo = true;
		unidad = "";

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (esComienzo) {
			unidad = request.getParameter("unidad");
			request.setAttribute("unidad", unidad);
		} else {
			doPost(request, response);
			esComienzo = false;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Leemos los PARAMETROS de la vista
			String entrada = request.getParameter("num");
			String operacion = request.getParameter("operacion");
			unidad = request.getParameter("unidad");

			// Trabajamos con ellos
			if (entrada != null && entrada.trim().length() > 1) {
				try {
					// boolean esError = false; // Por si hay algún error inesperado

					num = Float.parseFloat(entrada);

					convierte(operacion, unidad, num);

				} catch (NumberFormatException e) {
					msg = "No se puede convertir " + entrada;
				}

			} else if ((entrada == null || entrada.isEmpty()) && !esComienzo) { // No se ha introducido nada
				msg = "El campo no puede estar vacío.";
			}

			// Enviamos los ATRIBUTOS
			request.setAttribute("msg", msg);

			// Llamamos a la VISTA
			request.getRequestDispatcher("conversor.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void convierte(String operacion, String unidad, float num) {

		String mensajeFinal = Float.toString(num);

		switch (operacion) {
		case "Metros a": // Metros - Pulgadas o Pulgadas a Metros
			if (unidad == "Pie") {

				resultado = num * PIE;
			} else {

				resultado = num * PULGADA;
			}

			mensajeFinal += " metros = " + Float.toString(resultado) + unidad;
			break;

		case "a Metros": // Pulgadas - Metros o Pies - Metros

			if (unidad == "Pie") {

				resultado = num / PIE;
			} else {

				resultado = num / PULGADA;
			}
			
			mensajeFinal += unidad + " = " + Float.toString(resultado) + " metros";
			break;

		default:
			msg = "Ha ocurrido un error inesperado. Por favor, vuelve a intentarlo.";
			break;
		}

		msg = mensajeFinal;

	}

}
