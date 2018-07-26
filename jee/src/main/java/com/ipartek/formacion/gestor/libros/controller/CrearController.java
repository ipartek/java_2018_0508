package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.libros.model.LibroArrayDAO;
import com.ipartek.formacion.gestor.libros.pojo.Libro;

@WebServlet("/crear")
public class CrearController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW_CREAR = "crear.jsp";
	private static String msg = "";

	private static LibroArrayDAO dao;
	private static Libro libro;
	private String titulo;
	private String isbn;
	private String editorial;
	private boolean prestado;
	
	private RequestDispatcher dispatch = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			dispatch = request.getRequestDispatcher(VIEW_CREAR);
			
			titulo = request.getParameter(titulo);
			isbn = request.getParameter(isbn);
			editorial = request.getParameter(editorial);
			if request.getParamete
			
		} catch (Exception e) {
			msg = "Ha ocurrido un error=>" + e.getMessage();
		} finally {
			request.setAttribute("msg", msg);
			dispatch.forward(request, response);

		}
		
	}

}
