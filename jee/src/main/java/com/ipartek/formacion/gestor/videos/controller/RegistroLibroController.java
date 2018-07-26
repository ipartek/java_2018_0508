package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.videos.pojo.Libro;

@WebServlet("/registrar-libro")
public class RegistroLibroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String CHECKED = "ON";
	
	private static long cont = 0;
	private static String msg;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("registro-libro.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editorial = request.getParameter("editorial");
		String isbn = request.getParameter("isbn");
		
		int numPaginas = Integer.parseInt(request.getParameter("numPaginas"));
		
		String checkbox = request.getParameter("esPrestado");
		
		boolean creado = false;
		boolean esPrestado = false;
		
		msg = "";
		
		if (CHECKED.equalsIgnoreCase(checkbox)) { // Comprobamos el checkbox
			
			esPrestado = true;
		}
		
		try {
			
			Libro nuevoLibro = new Libro(++cont, titulo, autor, editorial, isbn, numPaginas, esPrestado);
			msg = "Libro creado con éxito.";
			creado = true;
			request.setAttribute("libro", nuevoLibro);
			
		
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			
			msg = "Ha ocurrido un error al crear el libro.";
		}
		if (creado) {
			
			request.getRequestDispatcher("confirmar-registro-libro.jsp").forward(request, response);
		
		} else {
			
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("registro-libro.jsp").forward(request, response);
			
		}
	}

}
