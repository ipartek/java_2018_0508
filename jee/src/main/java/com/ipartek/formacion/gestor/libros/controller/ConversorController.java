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
	private static double uDato;
	private static double resul;
	private static double valor;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DecimalFormat df = new DecimalFormat("#.00");
		resul = 0;
		
		try {
			dispatch = request.getRequestDispatcher(VIEW);
			uDato = Double.parseDouble(request.getParameter("formulario"));
			valor = Double.parseDouble(request.getParameter("valor"));
			
			if (uDato==1) {
				resul = valor * PIES;
				request.setAttribute("resultadoPies", df.format(resul));
			}else if(uDato==2) {
				resul = valor / PIES;
				request.setAttribute("resultadoMetros", df.format(resul));
			}
			
		} catch (NumberFormatException e) {
			if (e.getMessage().contains("empty String")) {
				msg="introduce un numero por favor";
			}else {
				msg="Solo se aceptan numeros ";
			}
		}finally {
			
			request.setAttribute("msg", msg);
			dispatch.forward(request, response);
		}

	}
	
}
