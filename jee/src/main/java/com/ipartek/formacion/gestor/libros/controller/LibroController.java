package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/libro")
public class LibroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW = "libro.jsp";
	private static final String VIEW_LISTADO = "listado.jsp";
	private static String isbn = "";
	private static String titulo = "";
	private static String editorial = "";
	private static boolean prestado = false;
	private static final int ISBN_MIN_LENGTH = 5;
	private static String ISBN_MIN_EXCEPTION = "La longitud mínima del ISBN debe de ser " + ISBN_MIN_LENGTH;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			dispatch = request.getRequestDispatcher(VIEW);
			isbn = request.getParameter("isbn");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			prestado = request.getParameter("prestado") != null;

			if (isbn.isEmpty() || titulo.isEmpty() || editorial.isEmpty()) {
				request.setAttribute("msg", "Hay campos vacios");
			} else {
				if (isbn.length() >= ISBN_MIN_LENGTH) {
					request.setAttribute("isbn", isbn);
					request.setAttribute("titulo", titulo);
					request.setAttribute("editorial", editorial);
					if (prestado) {
						request.setAttribute("prestado", "Prestado");
						
					} else {
						request.setAttribute("prestado", "Sin prestar");
						//request.getRequestDispatcher(VIEW_LISTADO).forward(request, response);
					}
					request.getRequestDispatcher(VIEW_LISTADO).forward(request, response);
				} else {
					request.setAttribute("msg", ISBN_MIN_EXCEPTION);
					request.getRequestDispatcher(VIEW).forward(request, response);
				}//fin lenght
			}//fin empty

		} catch (Exception e) {

			request.setAttribute("msg", "Ha surgido un problema");

		} finally {

			request.setAttribute("isbn", isbn);
			request.setAttribute("titulo", titulo);
			request.setAttribute("editorial", editorial);
			request.setAttribute("prestado", prestado);
			dispatch.forward(request, response);
		}

	}

}