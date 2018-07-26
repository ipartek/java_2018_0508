package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.pojo.Libro;

@WebServlet("/crear-libro")

public class LibroController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch = null;

	private static final String VIEW_CORRECTA = "verLibro.jsp";
	private static final String VIEW_FALLO = "crearLibro.jsp";
	private static long ULTIMO_ID = 0;

	private static String MSG = " ";

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

		String titulo = " ";
		String isbn = " ";
		String editorial = " ";
		String check = " ";

		try {

			dispatch = request.getRequestDispatcher(VIEW_FALLO);

			titulo = request.getParameter("titulo");
			isbn = request.getParameter("isbn");
			editorial = request.getParameter("editorial");
			check = request.getParameter("prestado");
			Boolean prestado = ("on".equals(check)) ? true : false;

			Libro l = new Libro(ULTIMO_ID, titulo, isbn, editorial, prestado);

			if (l != null) {
				dispatch = request.getRequestDispatcher(VIEW_CORRECTA);
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
			request.setAttribute("prestado", check);

		} finally {

			dispatch.forward(request, response);

		}

	}
}
