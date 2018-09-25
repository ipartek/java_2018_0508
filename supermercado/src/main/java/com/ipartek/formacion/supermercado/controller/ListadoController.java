package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class ListadoController
 */
@WebServlet("/listado")
public class ListadoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ProductoArrayListDAO dao;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			dao = ProductoArrayListDAO.getInstance();
			request.setAttribute("productos", dao.getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("privado/listado.jsp").forward(request, response);
		}
		
		
	}

}
