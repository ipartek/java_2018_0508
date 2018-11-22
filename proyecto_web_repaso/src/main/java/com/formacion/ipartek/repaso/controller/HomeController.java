package com.formacion.ipartek.repaso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/flujo-clasico")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int op1;
	private int op2;
	private int suma;
	
	private static String view = "";
	
	// Logger
	private final static Logger LOG = Logger.getLogger(HomeController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	}
	
	

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			//Recibir parametros
			getParameters(request, response);
			//Validar
			//Aplicar la logica de negocio
			suma = op1 + op2;
			//Enviar atributos
			request.setAttribute("suma", suma);
			view = "resultado.jsp";
		}catch(NumberFormatException e) {
			LOG.error("Debes introducir números obligatoriamente");
			request.setAttribute("error", "Debes introducir números obligatoriamente");
			view = "index.jsp";
		}catch(Exception e) {
			request.setAttribute("error", "Debes introducir números obligatoriamente");
			LOG.error(e);
		}
		
		//Pasar a la siguiente vista
		request.getRequestDispatcher(view).forward(request, response);
	}

	private void getParameters(HttpServletRequest request, HttpServletResponse response) {
		op1 = Integer.parseInt(request.getParameter("op1"));
		op2 = Integer.parseInt(request.getParameter("op2"));
	}

}
