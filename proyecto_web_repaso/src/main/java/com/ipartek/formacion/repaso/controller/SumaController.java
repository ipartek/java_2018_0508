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
	 * @see HttpServlet#HttpServlet()
	 */
	public SumaController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recibir parametros
		String primerParametro = request.getParameter("op1");
		String segundoParametro = request.getParameter("op2");
		// validar

		// aplicar la logica de negocio o capa servicio
		int parametroUno = Integer.parseInt(primerParametro);
		int parametroDos = Integer.parseInt(segundoParametro);
		int suma = parametroUno + parametroDos;
		System.out.println(suma);

		// respondo al usuario: enviar atributos e ir a la vista
		request.setAttribute("suma", suma);
		request.getRequestDispatcher("resultado.jsp").forward(request, response);

	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			// recibir parametros
			String primerParametro = request.getParameter("op1");
			String segundoParametro = request.getParameter("op2");
			String msg = "";

			// aplicar la logica de negocio o capa servicio
			int parametroUno = Integer.parseInt(primerParametro);
			int parametroDos = Integer.parseInt(segundoParametro);
			int suma = parametroUno + parametroDos;

			// respondo al usuario: enviar atributos e ir a la vista
			request.setAttribute("suma", suma);
			request.getRequestDispatcher("resultado.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}

	}

}
