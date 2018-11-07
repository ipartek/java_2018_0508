package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/inicio" }, initParams = {
		@WebInitParam(name = "numProductos", value = "10", description = "Número de productos iniciales al cargar la página de inicio.") })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductoArrayListDAO dao;
	ArrayList<Producto> productos;

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		dao = ProductoArrayListDAO.getInstance();
	}


	public void destroy() {
		
		dao = null;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			cargarProductos();
			
			request.setAttribute("numProductos", this.getServletConfig().getInitParameter("numProductos"));
			request.setAttribute("productos", productos);
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}

	private void cargarProductos() {
		
		// Listado de Productos
		productos = (ArrayList<Producto>) dao.getAll();
	}

	
}
