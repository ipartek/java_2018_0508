package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoController
 */
@WebServlet("/saludo")
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_SALUDO = "saludo.jsp";

	public SaludoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("pasamos por doGet");

		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 1.recibir parametros
		String nombre = (String) request.getParameter("nombre");
		String apellido1 = (String) request.getParameter("ap1");
		String apellido2 = (String) request.getParameter("ap2");

		// 2.Validar parametros si procede

		// 3. Llamar modelo DAO

		// 4.Enviar atributos vista
		request.setAttribute("nombre", nombre);
		request.setAttribute("ap1", apellido1);
		request.setAttribute("ap2", apellido2);

		// 5.Ir a la vista
		String nombreCompleto = String.format("nombre completo %s %s %s", nombre, apellido1, apellido2);
		request.getRequestDispatcher("saludo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Pasamos por el post");

		try {
			// 1.recibir parametros
			String nombre = (String) request.getParameter("nombre");

			// 2.Validar parametros si procede

			if (nombre != null && !"".equals(nombre.trim())) {

				request.setAttribute("nombre", nombre);
				dispatch = request.getRequestDispatcher(VIEW_SALUDO);

			} else {
				request.setAttribute("msg", "Introduce un nombre por favor");
				dispatch = request.getRequestDispatcher(VIEW_INDEX);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dispatch.forward(request, response);
		}

	}

}
