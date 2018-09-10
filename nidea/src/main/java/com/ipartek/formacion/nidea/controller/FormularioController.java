package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			//recoger parametros
			String codigo = request.getParameter("codigo");
			
			String codigo2 = request.getParameter("codigo22222");
			codigo2.trim();
			
			//validar parametros
			
			
			//crear Producto a traves de parametros recibidos del formulario
			Producto p = new Producto();
			p.setCodigo(codigo);
			
			//pasa parametro
			request.setAttribute("producto",  p );
			
			
			//ir a la vista
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			//enviar mensaje al usuario
			request.setAttribute("alert", "Lo sentimos pero tenemos un fallo inexsperado");
			
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
		}	
			
	}

}
