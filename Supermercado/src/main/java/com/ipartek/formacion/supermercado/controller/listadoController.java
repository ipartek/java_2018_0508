package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayDAO;

/**
 * Servlet implementation class listadoController
 */
@WebServlet("/privado/listado")
public class listadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ProductoArrayDAO dao;
	private static ArrayList<Producto> productos;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			dao = ProductoArrayDAO.getInstance();
			productos = (ArrayList<Producto>) dao.getAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("listado.jsp").forward(request, response);
		}
	}

}
