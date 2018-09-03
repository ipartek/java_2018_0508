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
public class CasaLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_CREAR = "casaCrearLibro.jsp";
	private static final String VIEW_MOSTRAR = "casaMostrarLibro.jsp";
	private static final String PRESTADO = "si";
	private static final int ISBN_MIN_LENGTH = 5;
	
	private RequestDispatcher dispatch = null;
	private static Libro libro = null;

	private static String msg = "";
	private static String isbn;
	private static String titulo;
	private static String editorial;
	private static String radioPrestado = "";
	private static long id = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		msg = "";
		boolean aux = false;

		try {

			dispatch = request.getRequestDispatcher(VIEW_CREAR);

			isbn = request.getParameter("isbnForm");
			titulo = request.getParameter("tituloForm");
			editorial = request.getParameter("editorialForm");
			radioPrestado = request.getParameter("prestadoForm");

			if (isbn != null && isbn.trim().length() >= ISBN_MIN_LENGTH && titulo != null && editorial != null
					&& radioPrestado != null) {

				aux = (PRESTADO.equals(radioPrestado)) ? true : false;

				dispatch = request.getRequestDispatcher(VIEW_MOSTRAR);

				libro = new Libro(id, isbn, titulo, editorial, aux);
				request.setAttribute("libro", libro);
				
				
				switch (String.valueOf(libro.isPrestado())) {
				case "true":
					request.setAttribute("prestado", "Si");
					break;

				default:
					request.setAttribute("prestado", "No");
					break;
				}
			
			
				
			}

		} catch (Exception e) {

			request.setAttribute("isbnForm", titulo);
			request.setAttribute("tituloForm", isbn);
			request.setAttribute("editorialForm", editorial);
			request.setAttribute("prestadoForm", radioPrestado);
		} finally {

			dispatch.forward(request, response);
		}
	}

}
