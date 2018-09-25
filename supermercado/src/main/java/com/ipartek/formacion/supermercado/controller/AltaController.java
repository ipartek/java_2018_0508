package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.Alert;
import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class AltaController
 */
@WebServlet("/alta")
public class AltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductoArrayListDAO dao;
	private ArrayList<Producto> productos;
	private static long ID = 5;
    
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alert alert = new Alert();
		
		try {
			
			String nombre = request.getParameter("nombre");
			float precio = Float.parseFloat(request.getParameter("precio"));
			int descuento = Integer.parseInt(request.getParameter("descuento"));
			String precioUnidad = request.getParameter("precioUnidad");
			String descripcion = request.getParameter("descripcion");
			String imagen = request.getParameter("imagen");
			
			Producto p = new Producto(++ID, nombre, precio, descuento, imagen, precioUnidad, descripcion);
			
			productos = (ArrayList<Producto>) dao.getAll();

			int cantidadProductos = productos.size();
			
			productos.add(p);	

			if((cantidadProductos + 1) == productos.size()) {
				alert.setTexto("Producto <i>" + p.getNombre() + "</i> insertado correctamente");
				alert.setTipo(Alert.SUCCESS);
			}else {
				alert.setTexto("Error. El producto no a sido insertado");
			}
			
			request.setAttribute("producto", p);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("privado/alta-producto.jsp").forward(request, response);
		}
			
		
		
	}

}
