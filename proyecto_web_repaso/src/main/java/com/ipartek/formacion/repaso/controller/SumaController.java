package com.ipartek.formacion.repaso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class SumaController
 */
@WebServlet("/flujo-clasico")
public class SumaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(SumaController.class);
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int suma = 0;
		String msgError = "";
		String view = "index.jsp";
		
		//Recibir parámetros
		String p1 = request.getParameter("op1");
		String p2 = request.getParameter("op2");
		
		//Validar parámetros
		
		try {
			suma = Integer.parseInt(p1) + Integer.parseInt(p2);
			LOG.debug("Suma realizada");
			
		} catch (NumberFormatException e) {
			msgError = "Introduzca números por favor";
			LOG.error(e);
		}
		
		if("".equals(msgError)) {
			view = "resultado.jsp";
		}
		
		request.setAttribute("suma", suma);
		request.setAttribute("msgError", msgError);
		request.getRequestDispatcher(view).forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int suma = 0;
		String msgError = "";
		String view = "index.jsp";
		
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
		
		try {
			suma = Integer.parseInt(p1) + Integer.parseInt(p2);
			LOG.debug("Suma realizada");
			
		} catch (NumberFormatException e) {
			msgError = "Introduzca números por favor";
			LOG.error(e);
		}
		
		if("".equals(msgError)) {
			view = "resultado.jsp";
		}
		
		request.setAttribute("suma", suma);
		request.setAttribute("msgError", msgError);
		request.getRequestDispatcher(view).forward(request, response);		
		
	}

}
