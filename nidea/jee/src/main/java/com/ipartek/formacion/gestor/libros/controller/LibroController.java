package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formulario")

public class LibroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_DETALLE_LIBRO = "detalleLibro.jsp";

	private static String isbn = "";
	private static String titulo = "";
	private static String editorial = "";
	private static String tipo = "";
	private static String msg = "";
	private int id = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dispatch = request.getRequestDispatcher(VIEW_DETALLE_LIBRO);

			id++;
			
			isbn = request.getParameter("isbn");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			tipo = request.getParameter("tipo");
			
			if(isbn==null || titulo==null ) {
				msg = "Falta algun dato";
			}

			if ("prestado".equals(tipo)) {
				request.setAttribute("tipo", tipo);

			} else if ("noprestado".equals(tipo)) {
				request.setAttribute("tipo", tipo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Ha ocurrido un error=>" + e.getMessage();
		} finally {

			request.setAttribute("id", id);
			request.setAttribute("isbn", isbn);
			request.setAttribute("titulo", titulo);
			request.setAttribute("editorial", editorial);
			request.setAttribute("msg", msg);
			request.setAttribute("tipo", tipo);
			dispatch.forward(request, response);
		}

	}

}
