package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrestamosController
 */
@WebServlet("/conversor")
public class ConversorController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final int FORMULARIO1 = 1;
	public static final int FORMULARIO2 = 2;
	
	public static final float PIE = 3.28f;
	  
	//parametros
	private String paramUnidad;	
	private String paramFormulario;
	
	//atributos
	private String mensaje = "";
	private String resultado1 = "";
	private String resultado2 = "";
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int formulario = FORMULARIO1;
		try {
			paramUnidad = request.getParameter("unidad");			
			paramFormulario = request.getParameter("formulario");			
			formulario = Integer.parseInt(paramFormulario);
			
			if ( formulario == FORMULARIO1 ) {
				//metros a pies
				resultado1 = paramUnidad;
				resultado2 = String.valueOf( Integer.parseInt(paramUnidad) * PIE );
			}else {
				//pies a metros				
				resultado1 = String.valueOf( Integer.parseInt(paramUnidad) / PIE );
				resultado2 = paramUnidad;
			}
			
			
			//mensaje = "TODO realizar conversion";
		
		}catch( NumberFormatException e) {
			
			if ( e.getMessage().contains("For input string: \"\"")) {
				mensaje = "Por favor inserta un valor";				
			}else {
				mensaje = "Lo sentimos no podemos convetir " + paramUnidad ;					
			}
			
			if ( formulario == FORMULARIO1 ) {
				resultado1 = paramUnidad;
				resultado2 = "";
			}else {
				resultado1 = "";
				resultado2 = paramUnidad;
			}
			
			
		}catch (Exception e) {
			mensaje = "Lo sentimos pero tenemos un fallo Inesperado ";
			e.printStackTrace();
			
		}finally {		
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("resultado1", resultado1);
			request.setAttribute("resultado2", resultado2);
			request.getRequestDispatcher("conversor.jsp").forward(request, response);
		}
		
	}

}
