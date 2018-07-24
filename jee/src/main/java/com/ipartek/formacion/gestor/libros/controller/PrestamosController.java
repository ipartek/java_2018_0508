package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar")
public class PrestamosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG = Logger.getLogger(PrestamosController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO implementar logger
		System.out.println("pasamos por do get");
		
		//recibir parametros
		
		//validar parametros si proceden
		
		//llamar modelo DAO
		
		//enviar atributos a la vista
		
		//ir a la vista
		request.getRequestDispatcher("listado.jsp").forward(request, response);	
	}
}