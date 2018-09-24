package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.List;

import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class AltaProductoController
 */
@WebServlet("/altaproducto")
public class AltaProductoController extends HttpServlet {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("alta-producto.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String nom=request.getParameter("nom");
			float precio= Float.parseFloat(request.getParameter("precio"));
			int descuento= Integer.parseInt(request.getParameter("cant-descuento"));
			String litro= request.getParameter("litro");
			String descripcion= request.getParameter("desc");
			String img= request.getParameter("img");
			
			Producto p = new Producto(4,nom,precio,descuento,descripcion,img,litro);
			dao.insert(p);
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			request.getRequestDispatcher("home").forward(request, response);
		}
	}

}
