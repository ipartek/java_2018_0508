package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Producto;
import com.ipartek.formacion.nidea.pojo.Categoria;
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
		
		//TODO llamar al Modelo para recuperar 'Categorias'
	//	ArrayList<Categoria> cats = recuperarCategorias();
		
		//request.setAttribute("Categoria",cats );
		
		//pasar a la vista las categorias
		
		
		
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
	}

	//private ArrayList<Categoria> recuperarCategorias() {
	//ArrayList<Categoria> resul = new ArrayList<Categoria>();
	//resul.add(new Categoria(1,"COC","Cocina"));
	//resul.add(new Categoria(2,"SAL","Salon"));
	//resul.add(new Categoria(3,"COC","Cocina"));
		// TODO Auto-generated method stub
		//return resul;
	//}

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
			

			
			
			//validar parametros
			
			if ( codigo.isEmpty()  ) {
				
				//TODO validar resto de campos
				
				request.setAttribute("alert", new Alert( Alert.WARNING , "Faltan campos obligatorios") );
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
	
				
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
			
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
		}	
			
	}

}