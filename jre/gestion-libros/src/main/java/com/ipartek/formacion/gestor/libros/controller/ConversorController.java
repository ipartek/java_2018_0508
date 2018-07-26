package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor")

public class ConversorController extends HttpServlet {

	private static final String VIEW = "conversor.jsp";
	private static final long serialVersionUID = 1L;
	public static final String FORMULARIO1 = "1";
	public static final String FORMULARIO2 = "2";

	public static final float METROS_A_PIES = 3.28f;

	// parametros (lo que recibo del jsp)
	private String paramMetros;
	private String paramPies;

	private String paramFormulario;

	// Atriubutos(Lo que envio al jsp)
	private static String msg = "";
	private static float resultado1 = 0f;
	private static float resultado2 = 0f;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		try {
			paramMetros = request.getParameter("unidadMetros");
			paramPies = request.getParameter("unidadPies");
			paramFormulario = request.getParameter("formulario");

			String formulario = paramFormulario;
			if (formulario.equalsIgnoreCase(FORMULARIO1)) {
				// metros a pies

				if (paramMetros != null && "".equalsIgnoreCase(paramMetros)) {
					resultado1 = Float.parseFloat(paramMetros);
					resultado2 = Integer.parseInt(paramMetros) * METROS_A_PIES;

				} else {
					// pies a metros
					resultado1 = Integer.parseInt(paramPies) / METROS_A_PIES;
					resultado2 = Float.parseFloat(paramPies);
				}

			}

		} catch (Exception e) {
			msg = "Lo sentimos pero tenemos un fallo inesperado. ";
		} finally {

			request.setAttribute("unidadMetros", paramMetros);
			request.setAttribute("unidadPies", paramPies);
			request.getRequestDispatcher(VIEW);
		}
	}

}
