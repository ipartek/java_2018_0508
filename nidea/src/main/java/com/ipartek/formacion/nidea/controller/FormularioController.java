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
		// TODO Auto-generated method stub

		try {
			ArrayList<Categoria> cats = recuperarCategorias();
			
			//pasar a la vista las categorias
			request.setAttribute("categorias", cats);
			
		}catch (Exception e) {
			// TODO: handle exception
		
		}finally {
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}
	}

	private ArrayList<Categoria> recuperarCategorias() {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		lista.add(new Categoria(0,"sal_98","Salon"));
		lista.add(new Categoria(0,"coc_54","Cocina"));
		lista.add(new Categoria(0,"wc_34","WC"));
		
		
		return lista;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		try {
			//Recoger parametros
			String nombre = request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
			String precio = request.getParameter("precio");
			String oferta = request.getParameter("oferta");
			String descripcion = request.getParameter("descripcion");
			
			//Validar parametros
	
			if(codigo.isEmpty()) {
				request.setAttribute("alert", new Alert(Alert.WARNING,"ERROR el campo 'codigo' está vacio"));
			}else {
				
				
				Producto p = new Producto();			
				p.setNombre(nombre);
				p.setCodigo(codigo);
				p.setPrecio(Float.parseFloat(precio));
				p.setOferta(("on".equalsIgnoreCase(oferta))?true:false);
				p.setDescripcion(descripcion);
						
				//Pasar parametros
				request.setAttribute("producto", p);
				
				Alert alert = new Alert(Alert.PRIMARY," Registro dado de alta");
				request.setAttribute("alert", alert);
				
				//Ir a la vista		
				request.getRequestDispatcher("resultado.jsp").forward(request, response);
			}

			

		}catch (Exception e) {
				request.getRequestDispatcher("formulario.jsp").forward(request, response);

			
		}
	

	}

}
