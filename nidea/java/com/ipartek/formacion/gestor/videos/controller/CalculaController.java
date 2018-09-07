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
	//private static final Logger LOG = Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Pasamos por doGet()");
		
		float result = 0;
		
		//1. Recibir parámetros
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		String operacion = request.getParameter("operacion");
		System.out.println(operacion);
		switch (operacion) {
		case "+":
			result = num1+num2;
			break;
		case "-":
			result = num1-num2;
			break;
		case "*":
			result = num1*num2;
			break;
		case "/":
			result = num1/num2;
			break;
		default:
			break;
		}
		//2. Validar parámetros
		//3. Llamar al modelo
		//4. Enviar atributos a la Vista
		request.setAttribute("resultado", result);
		//5. Ir a la vista
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
