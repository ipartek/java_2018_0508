package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.gestor.videos.pojo.Libro;

@WebServlet("/anadirLibro")
public class AnadirLibroControler extends HttpServlet {
	boolean prestado;
	long id = 0;

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		/*
		 * System.out.println("Pasamos por doPost()");
		 * 
		 * // 1. Recibir parámetros String usuarioLetra = (String)
		 * request.getParameter("letraAhorcado");
		 * 
		 * // 2. Validar parámetros if (usuarioLetra == null) {
		 * 
		 * request.setAttribute("msg", "Por favor rellena el nombre y no seas vago.");
		 * request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		 * 
		 * } else if (!usuarioLetra.trim().isEmpty()) { request.setAttribute("letra",
		 * usuarioLetra); }
		 * 
		 * // 4. Enviar atributos a la Vista
		 * request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		 */

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doPost( request, response);
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = (String) request.getParameter("titulo");
		String editorial = (String) request.getParameter("editorial");
		String isbn = (String) request.getParameter("isbn");
		String autor = (String) request.getParameter("autor");
		String prestado1 = (String) request.getParameter("prestado");
		
		try {
			
			System.out.println(prestado1);
			if (prestado1 == "on") {
				prestado = true;
			} else {
				prestado = false;
			}


			id = calculeId();
			// Libro libroNuevo = new Libro(id,titulo,autor,editorial,isbn, prestado);
			Libro libroNuevo2 = new Libro(id, titulo, autor, editorial, isbn, prestado);
			request.setAttribute("libroNuevo", libroNuevo2);
			System.out.println(libroNuevo2.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("detalleLibro.jsp").forward(request, response);
		}
		
		
	}

	private long calculeId() {

		return id++;
	}
}
