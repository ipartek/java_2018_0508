package com.ipartek.formacion.repaso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SumaController
 */
@WebServlet("/flujo-clasico")
public class SumaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Recibir Parametros
		
		String p1 = request.getParameter("op1");
		String p2 = request.getParameter("op2");
		if ((p1 != null) || (p2 != null)) {
			try {
				int uno = Integer.parseInt(p1);
				int dos = Integer.parseInt(p2);
				int suma = uno + dos;
			
				request.setAttribute("suma", suma);
				request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
			
			} catch(IOException e) {
				
			}
		} 

	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("numero1"));
	    int num2 = Integer.parseInt(request.getParameter("numero2"));
	    
	    int resultado = num1+num2;
	    request.setAttribute("suma", resultado);
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}
	}


