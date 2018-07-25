package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saludo")
public class SaludoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch = null;
	private static final String VIEW_INDEX = "index.jsp";
	private static final String VIEW_SALUDO = "saludo.jsp";
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("pasamos por do get Saludo");

		// 1. Recibir parametros
		String nombre = request.getParameter("nombre");
		String ape1 = request.getParameter("ape1");
		String ape2 = request.getParameter("ape2");

		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido 1: " + ape1);
		System.out.println("Apellido 2: " + ape2);

		// 2. Validar parametros si proceden

		// 3. Llamar modelo DAO

		// 4. Enviar atributos a la vista
		request.setAttribute("nombre", nombre);
		request.setAttribute("ape1", ape1);
		request.setAttribute("ape2", ape2);

		// Tambien se puede hacer de esta forma
		// String nombreCompleto = String.format("Nombre Completo: %s %s %s", nombre,
		// ape1, ape2);
		// request.setAttribute("nombreCompleto", nombreCompleto);

		// 5. Ir a la vista
		request.getRequestDispatcher("saludo.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dispatch = request.getRequestDispatcher(VIEW_INDEX);

			// 1. Recibir parametros
			String nombre = request.getParameter("nom");

			if (nombre != null && !nombre.equals("".trim())) {
				request.setAttribute("nom", nombre + " enviado por POST");
				dispatch = request.getRequestDispatcher(VIEW_SALUDO);
			} else {
				request.setAttribute("msg", "Por favor envía el nombre y no seas vaguete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dispatch.forward(request, response);
		}
	}
}
