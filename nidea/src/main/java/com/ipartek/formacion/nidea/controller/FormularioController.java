package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Producto;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet("/formulario")
public class FormularioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// recoger parametros
			String nombre=request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
		    Alert alert=new Alert();
			
			
			// validar parametros
			if (codigo.isEmpty()) {

				request.setAttribute("alert", new Alert(alert.ALERT_WARNING,"Introduce un texto en los campos"));
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
				
				
			}else {
				// crear Producto a traves de parametros recibidos del formulario
				Producto p = new Producto();
				
				p.setCodigo(codigo);

				// pasa parametro
				request.setAttribute("producto", p);
				request.setAttribute("alert", new Alert(alert.ALERT_PRIMARY,"dado de alta correctamente"));
				
				
			}

		} catch (Exception e) {
						// Si nos da error el server le mandamos al formulario de nuevo
						request.setAttribute("alert", new Alert());
						request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
		} finally {
			// ir a la vista
			
				request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
			
		}
	}

}