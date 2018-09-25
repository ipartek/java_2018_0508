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
import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Servlet implementation class AltaProductoController
 */
@WebServlet("/altaproducto")
public class AltaProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ProductoArrayDAO dao;
	
	//Parametros
	private String nombre = "";
	private float precio = 0;
	private float precioVolumen = 0;
	private int descuento = 0; //De 0 a 100
	private String descripcion = "";
	private String imagen = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doProcess(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="/privado/alta-producto.jsp";
		try {
			dao = ProductoArrayDAO.getInstance();
			//Recoger parametros
			nombre = request.getParameter("nombre");
			precio = Float.parseFloat(request.getParameter("precio"));
			precioVolumen = Float.parseFloat(request.getParameter("precioVolumen"));
			descuento =  Integer.parseInt(request.getParameter("descuento"));
			descripcion = request.getParameter("descripcion");
			imagen = request.getParameter("imagen");
			
			if(nombre != null){
				
				Producto p = new Producto();
				p.setId(10000);
				p.setNombre(nombre);
				p.setPrecio(precio);
				p.setPrecioVolumen(precioVolumen);
				p.setDescuento(descuento);
				p.setDescripcion(descripcion);
				p.setImagen(imagen);
				
				dao.insert(p);
				
				//Guardar Usuario en session
				view = "/privado/listado";
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Se limpiaria la url y apareceria /listado en lugar de /login. Limpia la url. 
			//Habria que pasar por parametro el msg porque sino con la redireccion se perderia
			response.sendRedirect(request.getContextPath() + view);
		}
		}

}
