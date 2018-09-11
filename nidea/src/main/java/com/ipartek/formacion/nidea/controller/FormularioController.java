package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.nidea.model.ProductosDao;
import com.ipartek.formacion.nidea.pojo.Alerts;
import com.ipartek.formacion.nidea.pojo.Producto;


/**
 * Servlet implementation class FormularioController
 */
@WebServlet("/formulario")
public class FormularioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ProductosDao productosDao;
	private static ArrayList<Producto> productos;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String listar = (String) request.getParameter("signal");
		if("listar".equals(listar)){
			request.getRequestDispatcher("listar.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			//recoger parametros
			String nombre = request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
			String precio = request.getParameter("precio");
			String oferta = request.getParameter("oferta");
			String descripcion = request.getParameter("descripcion");
			String listar = (String) request.getParameter("signal");
			
			System.out.println(nombre);
			System.out.println(codigo);
			System.out.println(precio);
			System.out.println(oferta);
			System.out.println(descripcion);
			System.out.println(listar);
			/*for (Producto p : productosDao) {
				
			}*/
			//validar parametros

			if("listar".equals(listar)){
				request.getRequestDispatcher("listar.jsp").forward(request, response);
				
			}
			
			if ( nombre.isEmpty() || codigo.isEmpty() || precio.isEmpty()  ) {
				
				request.setAttribute("alert", new Alerts( Alerts.WARNING , "Faltan campos obligatorios") );
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
			}else {
			
			
				//crear Producto a traves de parametros recibidos del formulario
				productosDao = ProductosDao.getInstance();
				Producto p = new Producto();
				p.setNombre(nombre);
				p.setCodigo(codigo);
				p.setPrecio(Float.parseFloat(precio));
				p.setOferta(("on".equalsIgnoreCase(oferta))? true : false);
				p.setDescripcion(descripcion);	
				productosDao.insert(p);
				
				
				
				//pasa parametro

				request.setAttribute("producto", p);
				request.setAttribute("alert", new Alerts( Alerts.SUCESS , "Registro Dado de Alta") );
				
				//ir a la vista
				request.getRequestDispatcher("resultado.jsp").forward(request, response);
			}	
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			//enviar mensaje al usuario
			request.setAttribute("alert", new Alerts() );
			
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
		}	
			
	}

}