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
		//validar
		
		
	// Aplicar la logica de negocio o llamo a la capa de servicio
	String resultado = p1 + p2;
		
	// responde al usuario (enviar atributos e ir vista)
	request.setAttribute("suma", resultado);
	request.getRequestDispatcher("resultado.jsp").forward(request, response);
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


