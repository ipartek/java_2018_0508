package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.pojo.Libro;

@WebServlet("/libro")
public class LibroController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch = null;

	private static final String VIEW = "libro.jsp";
	private static final String VIEW_PRESTAMO = "listado.jsp";

	private static long ID = 0;

	private static String MSG = " ";

	private static String isbn = "";
	private static String titulo = "";
	private static String editorial = "";
	private static boolean prestado = false;

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

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			dispatch = request.getRequestDispatcher(VIEW);

			titulo = request.getParameter("titulo");
			isbn = request.getParameter("isbn");
			editorial = request.getParameter("editorial");
			prestado = request.getParameter("prestado") != null;

			Libro l = new Libro(ID, titulo, isbn, editorial, prestado);

			if (l != null) {
				request.getRequestDispatcher(VIEW_PRESTAMO).forward(request, response);
				request.setAttribute("libro", l);
			}

		} catch (NullPointerException e) {
			// e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
			MSG = "EL ISBN tiene que tener 5 digitos";
			request.setAttribute("msg", MSG);

			request.setAttribute("titulo", titulo);
			request.setAttribute("isbn", isbn);
			request.setAttribute("editorial", editorial);
			request.setAttribute("prestado", prestado);

		} finally {

			dispatch.forward(request, response);

		}

	}
}