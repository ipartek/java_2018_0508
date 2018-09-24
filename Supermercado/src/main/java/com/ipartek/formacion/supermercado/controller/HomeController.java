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
import com.ipartek.formacion.supermercado.model.ProductoArrayDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(
		urlPatterns = { "/home"}, 
		initParams = { 
				@WebInitParam(name = "numeroProductos", value = "10", description = "Numero de productos a mostrar en la página principal")
		})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ProductoArrayDAO dao;
	private static ArrayList<Producto> productos;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = ProductoArrayDAO.getInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		dao = null;
	}

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
		String numeroProductos = "" ;
		try {
			numeroProductos = this.getServletConfig().getInitParameter("numeroProductos");
			
			productos = (ArrayList<Producto>) dao.getAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("numeroProductos", numeroProductos);
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
