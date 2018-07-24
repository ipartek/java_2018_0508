package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listar")
public class PrestamosController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG=Logger.getLogger(PrestamosController.class);
	
	@Override
	//Request seria la peticion y response la respuesta
	//doGet===Recibe datos
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO IMPLEMENTAR LOGGER
		System.out.println("pasamos por doGet");
		
		//1.- RECIBIR PARAMETROS
		
		//2.-VALIDAR PARAMENTROS
		
		//3.- LLAMAR MODELO DAO
		
		//4.- ENVIAR ATRIBUTOS VISTA
		
		
		//5.-IR A LA VISTA
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
	}
}
