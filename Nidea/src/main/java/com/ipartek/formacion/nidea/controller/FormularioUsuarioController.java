package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioUsuarioController
 */
@WebServlet("/registro")
public class FormularioUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_REGISTRO = "registro.jsp";
	
	private RequestDispatcher dispatch = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		dispatch = request.getRequestDispatcher(VIEW_REGISTRO);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatch = request.getRequestDispatcher(VIEW_REGISTRO);
		dispatch.forward(request, response);
	}

}
