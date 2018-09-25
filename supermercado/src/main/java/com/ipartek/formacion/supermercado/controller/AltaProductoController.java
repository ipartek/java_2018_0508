package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class LogOutController
 */
@WebServlet("/altaProducto")

public class AltaProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Producto> productos;
	private static ProductoArrayListDAO dao;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		dao = ProductoArrayListDAO.getInstance();
		
		
		try {
			
			Producto producto = new Producto();
			String nombre = (String) request.getParameter("nombre");
			float precio = Float.parseFloat(request.getParameter("precio"));
			int descuento =Integer.parseInt(request.getParameter("cant-descuento"));
			String imagen = request.getParameter("imagen");
			String descripcion = request.getParameter("descripcion");
			float precioVolumen = Float.parseFloat(request.getParameter("litro"));
			
			Producto p = new Producto();			
			
			p.setImagen(p.IMAGEN);
			p.setImagen(imagen);
			p.setNombre(nombre);			
			p.setPrecio(precio);
			p.setDescripcion(descripcion);
			p.setDescuento(descuento);
			p.setPrecioVolumen(precioVolumen);
			
			// pasa parametro
			dao.insert(p);			
						
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			// ir a la vista
			
			request.getRequestDispatcher("listado").forward(request, response);
		
		
	}

	}

}
