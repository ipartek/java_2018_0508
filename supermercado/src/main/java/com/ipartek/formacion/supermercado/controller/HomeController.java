package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/home", "/inicio" },
			initParams = {
		@WebInitParam(name = "numeroProductos", value = "10", description = "Numero de productos a mostrar en el index") })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ProductoArrayListDAO dao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		dao = ProductoArrayListDAO.getInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {

			String numeroProductos = getServletContext().getInitParameter("numeroProductos");
			request.setAttribute("numeroProductos", numeroProductos);
			
			request.setAttribute("productos", dao.getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}
}
