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

	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch = null;
	private static final String VIEW = "conversor.jsp";

	private static String MSG = "INTRODUCE UN NUMERO...";

	private static final String OPCION_METROS = "1";
	private static final String OPCION_PIES = "2";
	private static final double MAP = 3.28084; // Un Metro es 3,28084 Pies
	private static final double PAM = 0.3048; // Un Pie es 0,3048 Metro

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

			double conversion = 0.0;
			double metros = 0.0;
			double pies = 0.0;

			dispatch = request.getRequestDispatcher(VIEW);

			// 1.- Recibir Parametros

			if ("".equals(request.getParameter("metros")) && "".equals(request.getParameter("metros"))) {
				MSG = "OYE TIENES QUE INTRODUCIR ALGUN NUMERO...";
			}

			// 2.- Validar Parametros

			if (OPCION_METROS.equals(request.getParameter("formulario"))) {
				
				metros = Double.parseDouble(request.getParameter("metros"));
				conversion = metros * MAP;
				request.setAttribute("conversion", metros+" metros son "+conversion+" pies.");
				
			}else if(OPCION_PIES.equals(request.getParameter("formulario"))){
				
				pies = Double.parseDouble(request.getParameter("metros"));
				conversion = pies * PAM;
				request.setAttribute("conversion", pies+" pies son "+conversion+" metros.");
				
			}

			// 3.- LLamar modelo DAO

			// 4.- Enviar atributos a la vista

			

			// 5.- Ir a la vista

		} catch (NumberFormatException e) {
			// e.printStackTrace();
			MSG = "No puedes convertir texto a numeros";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			request.setAttribute("metros", "");
			request.setAttribute("pies", "");
			request.setAttribute("msg", MSG);
			dispatch.forward(request, response);

		}

	}
}
