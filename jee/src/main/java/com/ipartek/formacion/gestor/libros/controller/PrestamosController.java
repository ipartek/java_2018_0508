package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar")  //La url a la que hay que escuchar, SIEMPRE empieza por barra( / )
public class PrestamosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//private static final Logger log = Logger.getLogger(PrestamosController.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO implementar logger
		System.out.println("Pasamos por doGet()");
		
		//1. Recibir parámetros
		
		
		//2. Validar parámetros(si procede)
		
		
		//3. Llamar modelo DAO
		
		
		//4. Enviar atributos al la vista
		
		
		//5. Ir a la vista
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
	}
	
}
