package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;
import com.ipartek.formacion.supermercado.model.pojo.Producto;

/**
 * Servlet implementation class AltaProductoController
 */
@WebServlet("/altaProducto")
public class AltaProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoArrayListDAO dao;
	private ArrayList<Producto> productos;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = ProductoArrayListDAO.getInstance();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		productos=(ArrayList<Producto>) dao.getAll();
		int descuento=0;
		try {
			String nombre = (String) request.getParameter("nombre");
			float precio = Float.parseFloat(request.getParameter("precio")) ;
			int cantidad = Integer.parseInt(request.getParameter("cantidad")) ;
			if ((request.getParameter("descuento")!="")) {
				descuento = Integer.parseInt(request.getParameter("descuento"));
			}
			
			float precioCantidad = Float.parseFloat( request.getParameter("precioCantidad"));
			String descripcion = (String) request.getParameter("descripcion");
			String imagen = (String) request.getParameter("imagen");
			for (int i = 0; i < cantidad; i++) {
				Producto p = new Producto();
				p.setNombre(nombre);
				p.setPrecio(precio);
				p.setDescuento(descuento);
				p.setPrecioCantidad(precioCantidad);
				p.setDescripcion(descripcion);
				p.setImagen(imagen);
				
				productos.add(p);
				

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("/privado/alta-producto.jsp").forward(request, response);
		}

	}

}
