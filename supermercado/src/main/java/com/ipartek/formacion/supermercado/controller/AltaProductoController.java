package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class AltaProductoController
 */
@WebServlet("/altaProducto")
public class AltaProductoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ProductoArrayListDAO dao;
	private long ultimoID = 142;
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
			String nombre = request.getParameter("nombre");
			float precio = Float.parseFloat(request.getParameter("precio"));
			int descuento = Integer.parseInt(request.getParameter("descuento"));
			String imagen = request.getParameter("imagen");
			String precioUnidad = request.getParameter("precioUnidad");
			String descripcion = request.getParameter("descripcion");
			
			Producto p = new Producto(ultimoID, nombre, precio, descuento, imagen, precioUnidad, descripcion);
			
			dao = ProductoArrayListDAO.getInstance();
			dao.insert(p);
			
			HttpSession session = request.getSession();
			session.setAttribute("productos", dao.getAll());
			request.setAttribute("producto", p);
			request.getRequestDispatcher("/privado/alta-producto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
