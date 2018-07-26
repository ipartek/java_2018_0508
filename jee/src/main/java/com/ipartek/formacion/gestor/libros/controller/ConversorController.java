package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor")
public class ConversorController extends HttpServlet {

	public static final int FORM1 = 1;
	public static final int FORM2 = 2;

	public static final float PIE = 3.28f;
	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_CONVERSOR = "conversor.jsp";
	private static double conversor = 0;

	private static String pies = "";
	private static String metros = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			String formulario = request.getParameter("formulario");
			dispatch = request.getRequestDispatcher(VIEW_CONVERSOR);

			if (Integer.parseInt(formulario) == FORM1) {
				if (isNumeric(request.getParameter("metros")) == false) {
					request.setAttribute("msgmetros",
							"No se puede convertir " + request.getParameter("metros") + " a metros");
					request.setAttribute("metros", metros);
					request.setAttribute("pies", pies);
					dispatch.forward(request, response);
				}
				double metros = Double.parseDouble(request.getParameter("metros"));

				if (metros != 0) {
					conversor = (metros * PIE);

					request.setAttribute("conversormetros", conversor);
					dispatch = request.getRequestDispatcher(VIEW_CONVERSOR);

				} else {
					request.setAttribute("msgpies", "Por favor introduce un valor para convertir a pies");
					request.setAttribute("metros", metros);
					request.setAttribute("pies", pies);
					dispatch.forward(request, response);
				}

			} else {

				if (isNumeric(request.getParameter("pies")) == false) {
					request.setAttribute("msgpies",
							"No se puede convertir " + request.getParameter("pies") + " a pies");
					request.setAttribute("metros", metros);
					request.setAttribute("pies", pies);
					dispatch.forward(request, response);
				}
				double pies = Double.parseDouble(request.getParameter("pies"));

				if (pies != 0) {
					conversor = (pies / PIE);

					request.setAttribute("conversorpies", conversor);
					dispatch = request.getRequestDispatcher(VIEW_CONVERSOR);
				} else {
					request.setAttribute("msgpies", "Por favor introduce un valor para convertir a pies");
					request.setAttribute("metros", metros);
					request.setAttribute("pies", pies);
					dispatch.forward(request, response);
				}
			}

		} catch (Exception e) {
			request.setAttribute("msg", "Ha surgido un problema");
		} finally {
			request.setAttribute("metros", metros);
			request.setAttribute("pies", pies);
			request.getRequestDispatcher(VIEW_CONVERSOR).forward(request, response);
		}

	}

	public static boolean isNumeric(String metros) {

		boolean resultado;

		try {
			Integer.parseInt(metros);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}
}
