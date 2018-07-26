package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.pojo.Libro;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_MSG = "Los datos introducidos no son correctas.";
	private static final String ERROR_PATH = "libro.jsp";
	private static final String LIBRO_PATH = "detalleLibro.jsp";
	private static final int ISBN_LONG = 5;

	// parametros (lo que recibo del jsp)
	private String isbn = "";
	private String titulo = "";
	private String editorial = "";
	private boolean prestado = false;
	private String msg = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		try {
			isbn = request.getParameter("isbn");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			prestado = Boolean.parseBoolean(request.getParameter("prestado"));

			if (isbn != null && titulo != null && editorial != null) {
				if (comprobarIsbn(isbn)) {
					Libro libro = new Libro();
					libro.setIsbn(isbn);
					libro.setTitulo(titulo);
					libro.setEditorial(editorial);
					libro.setPrestado(prestado);
					request.setAttribute("libro", libro);
					request.getRequestDispatcher(LIBRO_PATH).forward(request, response);

				} else {
					msg = "Por favor el isbn debe contener al menos 5 caracteres";
				}
			}

		} catch (NullPointerException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				request.setAttribute("msg", msg);
				request.getRequestDispatcher(ERROR_PATH).forward(request, response);
			} catch (ServletException e) {

			} catch (IOException e) {

				e.printStackTrace();
			}

			request.setAttribute("msg", "");

		}

	}

	private boolean comprobarIsbn(String isbn) {
		boolean result = false;
		if (isbn.length() >= ISBN_LONG) {
			result = true;
		}

		return result;
	}

}
