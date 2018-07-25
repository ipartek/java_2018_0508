package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher dispatch = null;
	private static final String VIEW_CALCULADORA = "calculadora.jsp";
	
	private static String msg = "";
	private static double numero1 = 0;
	private static char operando = 0;
	private static double numero2 = 0;
	

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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			dispatch = request.getRequestDispatcher(VIEW_CALCULADORA);
			numero1 = Integer.valueOf(request.getParameter("numero1"));
			numero2 = Integer.valueOf(request.getParameter("numero2"));
		}catch(Exception e) {
			msg = "Error.";
		}finally {
			request.setAttribute("msg", msg);
			dispatch.forward(request, response);
		}
	}
}
