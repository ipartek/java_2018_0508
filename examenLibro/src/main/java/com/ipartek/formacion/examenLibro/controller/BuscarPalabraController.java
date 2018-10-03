package com.ipartek.formacion.examenLibro.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examenLibro.model.LibroArrayListDAO;
import com.ipartek.formacion.examenLibro.model.Pagina;

/**
 * Servlet implementation class BuscarPalabraController
 */
@WebServlet("/buscar")
public class BuscarPalabraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static LibroArrayListDAO dao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = LibroArrayListDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selecPalabra = request.getParameter("selecPalabra");
		String texto = request.getParameter("texto");

	}

}
