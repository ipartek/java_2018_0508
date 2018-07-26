package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcular")
public class CalculaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// CONSTANTES DE LA CALCULADORA
	private static final String SUMA = "+";
	private static final String RESTA = "-";
	private static final String MULT = "*";
	private static final String DIVISION = "/";
	
	private static float result = 0;
	private static String msg = "";


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// 1. Recibir los PARÁMETROS de la vista
			String numero1 = request.getParameter("num1");
			String numero2 = request.getParameter("num2");
			String operacion = request.getParameter("operacion");

			if (operacion != null) {

				int num1 = Integer.parseInt(numero1);
				int num2 = Integer.parseInt(numero2);
				calcula(operacion, num1, num2);

			} else {

				msg = "Por favor, selecciona una operación.";
			}

			// Enviamos los atributos deseados a la VISTA
						request.setAttribute("resultado", result);
						request.setAttribute("msg", msg);
						
			// 5. Ir a la vista
			request.getRequestDispatcher("calculadora.jsp").forward(request, response);

		} catch (Exception e) {

			msg = "Lo sentimos, ha ocurrido un error inesperado. Por favor, recargue y vuelva a interntarlo.";
		}

	}

	private void calcula(String operacion, int num1, int num2) {

		switch (operacion) {
		case SUMA:
			result = num1 + num2;
			break;
			
		case RESTA:
			result = num1 - num2;
			break;
			
		case MULT:
			result = num1 * num2;
			break;
			
		case DIVISION:
			result = num1 / num2;
			break;
			
		default:
			msg = "No se reconoce la operación. Por favor, vuelve a intentarlo.";
			break;
		}
	}

}
