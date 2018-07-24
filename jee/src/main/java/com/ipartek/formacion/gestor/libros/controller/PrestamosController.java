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
@WebServlet("/listar")
public class PrestamosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("pasamos por doGet");

		// 1.recibir parametros

		// 2.validar parametros

		// 3.llamar modelo DAO

		// 4.enviar atributos a la vista

		// 5.ir a la vista

		request.getRequestDispatcher("listado.jsp").forward(request, response);

		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

}
