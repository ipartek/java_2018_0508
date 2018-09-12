package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Categoria;
import com.ipartek.formacion.nidea.pojo.Producto;

/**
 * Servlet implementation class FormulariosController
 */
@WebServlet("/formulario")
public class FormularioProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_FORMULARIO = "formulario.jsp";
	private static final String VIEW_RESULTADO = "resultado.jsp";
	
	private RequestDispatcher dispatch = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Categoria> categorias = recuperarCategorias();
		
		//Pasar a la vista las categorias
		if(!categorias.isEmpty()) {
			request.setAttribute("categoria", categorias);
		}
		
		dispatch = request.getRequestDispatcher(VIEW_FORMULARIO);
		dispatch.forward(request, response);
	}

	private ArrayList<Categoria> recuperarCategorias() {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria(1, "COC", "Cocina"));
		categorias.add(new Categoria(2, "SAL", "Salón"));
		categorias.add(new Categoria(3, "WC", "Baños"));
		categorias.add(new Categoria(4, "HAB", "Habitación"));
		return categorias;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Recoger parametros 
			String nombre = request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
			String descripcion = request.getParameter("descripcion");
			String precio = request.getParameter("precio");
			String oferta = request.getParameter("oferta");
			//String imagen = request.getParameter("imagen");
			
			//Validar parametros
			if(nombre.isEmpty() || codigo.isEmpty() || descripcion.isEmpty() || precio.isEmpty()) {
				request.setAttribute("alert", new Alert(Alert.ALERT_WARNING , "Faltan campos obligatorios.") );
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
			}else{
				//Crear Producto a traves de parametros
				Producto p = new Producto();
				p.setNombre(nombre);
				p.setCodigo(codigo);
				p.setPrecio(Float.parseFloat(precio));
				p.setOferta(("on".equalsIgnoreCase(oferta))?true:false);
				p.setDescripcion(descripcion);
				//p.setImagen(imagen);
				
				//Pasar parametros
				request.setAttribute("producto", p);

				Alert alert = new Alert(Alert.ALERT_SUCCESS, "Registro dado de alta correctamente. Quieres crear un nuevo registro?");
				request.setAttribute("alert", alert);
				
				//Ir a la vista
				dispatch = request.getRequestDispatcher(VIEW_RESULTADO);
				dispatch.forward(request, response);
			}		
			
		}catch(Exception e) {
			e.printStackTrace();
			
			//Enviar un mensaje al usuario
			//alertText = "Lo sentimos. Se ha generado un error inesperado.";
			request.setAttribute("alert", new Alert());
			
			dispatch = request.getRequestDispatcher(VIEW_FORMULARIO);
			dispatch.forward(request, response);
		}
		
	}

}
