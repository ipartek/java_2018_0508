package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.pojo.Libro;

@WebServlet("/insertarlibro")
public class InsertarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatch = null;
	private static final String VIEW_INSERTARLIBRO = "insertarlibro.jsp";
	private static final String VIEW_RESUMENLIBRO = "resumenlibro.jsp";
	public static final int ISBN_MIN_LENGTH = 5;
	public static final String ISBN_MIN_EXCEPTION = "La longitud minima del ISBN tiene que ser " + ISBN_MIN_LENGTH;

	// parametros
	private static String isbn;
	private static String titulo;
	private static String editorial;
	private static boolean prestado;

	// atributos
	private static String msg = "";
	private static Libro libro;

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
		msg = "";
		try {
			dispatch = request.getRequestDispatcher(VIEW_INSERTARLIBRO);

			titulo = request.getParameter("titulo");
			isbn = request.getParameter("isbn");
			editorial = request.getParameter("editorial");
			prestado = Boolean.parseBoolean(request.getParameter("prestado"));

			if (titulo != null) {
				if (!titulo.equals("") && !isbn.equals("") && !editorial.equals("")
						&& !isbn.equals("")) {
					if(isbn.length() >= ISBN_MIN_LENGTH) {
						libro = new Libro(isbn, titulo, editorial, prestado);
						dispatch = request.getRequestDispatcher(VIEW_RESUMENLIBRO);
					}else
						msg = ISBN_MIN_EXCEPTION;					
				} else
					msg = "Debe rellenar todos los campos obligatorios.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Error en la llamada.";
		} finally {
			request.setAttribute("msg", msg);
			request.setAttribute("libro", libro);
			dispatch.forward(request, response);
		}
	}
}
