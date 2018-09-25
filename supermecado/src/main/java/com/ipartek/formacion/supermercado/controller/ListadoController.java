package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.pojo.Producto;
import com.ipartek.formacion.supermercado.model.pojo.ProductoArrayListDAO;
import com.ipartek.formacion.supermercado.model.pojo.Usuario;
import com.ipartek.formacion.supermercado.model.pojo.UsuarioArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(
		urlPatterns = { "/listado" })

public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductoArrayListDAO productosDao;
	private ArrayList<Producto> productos;
	boolean flag = false;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		productosDao = ProductoArrayListDAO.getInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		productosDao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Pasa por doGet");
		doProcess(request,response);
		//this.getServletConfig();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("ListadoController (doProcess)");
		productos = (ArrayList<Producto>) productosDao.getAll(); 
		request.setAttribute("productos",productos );
		request.getRequestDispatcher("privado/listado.jsp").forward(request, response);
	}
}

	
