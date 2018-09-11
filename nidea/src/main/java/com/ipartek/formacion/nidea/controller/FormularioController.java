package com.ipartek.formacion.nidea.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Categoria;
import com.ipartek.formacion.nidea.pojo.Producto;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet("/formulario")
public class FormularioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO llamar al modelo para recuperar categorias
		
		ArrayList<Categoria>cats=Categoria.recuperarCategorias();
		
		//pasar a la vista las caegorias
		request.setAttribute("categorias", cats);
		request.getRequestDispatcher("form.jsp").forward(request, response);
			
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
			//File archivo= request.getParameter("archivo");
			
			//validar parametros
			
			if ( codigo.isEmpty()  ) {
				
				//TODO validar resto de campos
				
				request.setAttribute("alert", new Alert( Alert.WARNING , "Faltan campos obligatorios") );
				request.getRequestDispatcher("form.jsp").forward(request, response);
				
			}else {
			
			
				//crear Producto a traves de parametros recibidos del formulario
				Producto p = new Producto();
				p.setNombre(nombre);
				p.setCodigo(codigo);
				p.setPrecio(Float.parseFloat(precio)); //TODO validar arriba
				p.setOferta(("on".equalsIgnoreCase(oferta))?true:false);
				p.setDescripcion(descripcion);
				
				//pasa parametro
				request.setAttribute("producto",  p );
				request.setAttribute("alert", new Alert( Alert.SUCCESS , "Registro Dado de Alta") );
				
				//ir a la vista
				request.getRequestDispatcher("resultado.jsp").forward(request, response);
			}	
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			//enviar mensaje al usuario
			request.setAttribute("alert", new Alert() );
			
			request.getRequestDispatcher("form.jsp").forward(request, response);
			
		}	
		
		
			
	}

}