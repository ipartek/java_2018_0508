package com.ipartek.formacion.nidea.controller;

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
		
		//TODO Llamar al MODELO para recuperar 'categorías'.
		
		ArrayList <Categoria> cats = recuperarCategorias();
		
		request.setAttribute("categorias", cats);
		
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

	private ArrayList<Categoria> recuperarCategorias() {
		
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		
		lista.add(new Categoria(1, "CO", "Cocina"));
		lista.add(new Categoria(2, "SA", "Salón"));
		lista.add(new Categoria(3, "WC", "Baño"));
		
		return lista;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//Recoger parámetros 
			String nombre = request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
			String descripcion = request.getParameter("descripcion");
			String oferta = request.getParameter("oferta");
			String precio = request.getParameter("precio");
			//String imagen = request.getParameter("imagen");
			
			//Validar parámetros
			
			if(codigo.isEmpty()) {
				
				request.setAttribute("alert", new Alert(Alert.WARNING_TYPE, "Faltan campos obligatorios"));
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
				//TODO validar el resto de parámetros
				
			}else {

				//Crear producto a través de parámetros recibidos del formulario
				Producto p = new Producto();
				p.setNombre(nombre);
				p.setCodigo(codigo);
				p.setDescripcion(descripcion);
				p.setOferta(("on".equalsIgnoreCase(oferta))?true:false);
				p.setPrecio(Float.parseFloat(precio));
				//p.setImagen(imagen);	//TODO validar arriba
	
				//Pasar parámetros
				request.setAttribute("producto", p);
				request.setAttribute("alert", new Alert(Alert.SUCCESS_TYPE,"Registro dado de alta"));
				
				//Ir a la vista
				request.getRequestDispatcher("resultado.jsp").forward(request, response);

			}
		
		} catch (Exception e) {

			e.printStackTrace();
			
			//Enviar mensaje al usuario
			request.setAttribute("alert", new Alert());
			
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}
		
	}

}
