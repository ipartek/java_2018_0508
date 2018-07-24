package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrestamosController
 */
@WebServlet("/listar") // Para decirle al controlador donde queremos que escuche.
public class PrestamosController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public PrestamosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("pasamos por doGet");

		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 1.recibir parametros

		// 2.Validar parametros si procede

		// 3. Llamar modelo DAO

		// 4.Enviar atributos vista

		// 5.Ir a la vista
		request.getRequestDispatcher("listado.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
