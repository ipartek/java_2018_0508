package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar") // llama al controller cuando se pulse la URL listar.

public class PrestamosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// TODO implementar LOOGER
	//Logger log = Logger.getLogger(PrestamosController.class.getName());

	// Recibir datos
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("pasamos por PrestamosController doGet");
		
		// 1. recibir parametros
		//String parametro=request.getParameter("nombre");
		
		// 2. validar parametros
		
		// 3. Llamar modelo DAO
		
		// 4. enviar Atributos vista
		//request.setAttribute("nombre", parametro);
		// 5. Ir a la vista
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
