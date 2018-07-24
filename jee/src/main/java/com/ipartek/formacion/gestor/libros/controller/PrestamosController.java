package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listado")

public class PrestamosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG = Logger.getLogger(PrestamosContoller.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("pasamos por doGet");

		// 1.Recibir para metros
		String parametros = request.getParameter("nombre");


		// 2.Validar parametros

		// 3.llamar modelo

		// 4.enviar Atributos vista
		request.setAttribute("nombre", parametros);

		// 5.Ir a la vista
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);

	}

}
