package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConversorController
 */
@WebServlet("/conversor")
public class ConversorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch = null;
	private static String msg = "";
	private static final String VIEW = "conversor.jsp";
	private static final double PIES = 3.28083989501;
	private static double formulario;
	private static double resul;
	private static double valorConvertir;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DecimalFormat df = null;
		resul = 0;
		String numUsuario = "";
		
		try {
			numUsuario = request.getParameter("valor");
			df = new DecimalFormat("#.00");
			dispatch = request.getRequestDispatcher(VIEW);
			formulario = Double.parseDouble(request.getParameter("formulario"));
			valorConvertir = Double.parseDouble(numUsuario);

			if (formulario == 1) {
				resul = valorConvertir * PIES;
				request.setAttribute("resultadoPies", valorConvertir + " metros son: " + df.format(resul) + " pies");
			} else if (formulario == 2) {
				resul = valorConvertir / PIES;
				request.setAttribute("resultadoMetros", valorConvertir + " pies son : " + df.format(resul) + " metros");
			}

		} catch (NumberFormatException e) {
			if (e.getMessage().contains("empty String")) {
				msg ="No se ha recibido ningun dato...introduce un numero por favor";
			} else {
				msg =numUsuario
						+ " no se puede convertir ...introduce un numero y si es decimal comprueba que usas el punto";
			}
		} finally {

			request.setAttribute("msg", msg);
			dispatch.forward(request, response);
		}

	}

}
