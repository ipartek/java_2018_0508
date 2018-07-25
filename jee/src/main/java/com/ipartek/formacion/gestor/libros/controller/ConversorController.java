package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor") // La url a la que hay que escuchar, SIEMPRE empieza por barra( / )
public class ConversorController extends HttpServlet {

	public static final int FORM1 =1;
	public static final int FORM2 =2;
	
	private static final long serialVersionUID = 1L;
	private static final String CONVERSOR_VIEW = "conversor.jsp";
	private RequestDispatcher dispatch = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			dispatch = request.getRequestDispatcher(CONVERSOR_VIEW);

			int formulario = Integer.parseInt(request.getParameter("form"));

			if (formulario == FORM1) {
				convertirAPies(request, response);
			} else if (formulario == FORM2) {
				convertirAMetros(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			dispatch.forward(request, response);
		}

	}

	private void convertirAPies(HttpServletRequest request, HttpServletResponse response) {

		String metrosTexto = request.getParameter("metros");
		int metros = 0;

		if (metrosTexto != null && !"".equals(metrosTexto.trim())) {

			try {
				metros = Integer.parseInt(metrosTexto);

				double piesCalculados = metros * 3.28084;
				request.setAttribute("piesCalculados", piesCalculados);

			} catch (Exception e) {
				request.setAttribute("msgNoNumeroMetros", "Lo siento, no puedo convertir " + metrosTexto + " a pies");
				e.printStackTrace();
			}

		} else {
			request.setAttribute("msgVacioMetros", "Por favor, introduce un número");

		}

	}

	private void convertirAMetros(HttpServletRequest request, HttpServletResponse response) {

		String piesTexto = request.getParameter("pies");
		int pies = 0;
		if (piesTexto != null && !"".equals(piesTexto.trim())) {

			try {
				pies = Integer.parseInt(piesTexto);

				double metrosCalculados = pies * 0.3048;
				request.setAttribute("metrosCalculados", metrosCalculados);

			} catch (Exception e) {
				request.setAttribute("msgNoNumeroPies", "Lo siento, no puedo convertir " + piesTexto + " a metros");
				e.printStackTrace();
			}

		} else {
			request.setAttribute("msgVacioPies", "Por favor, introduce un número");

		}

	}

}
