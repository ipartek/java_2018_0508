package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saludo")
public class SaludoController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG=Logger.getLogger(PrestamosController.class);
	
	@Override
	//Request seria la peticion y response la respuesta
	//doGet===Recibe datos
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO IMPLEMENTAR LOGGER
		System.out.println("pasamos por doGet");
		
		//1.- RECIBIR PARAMETROS
			String parametroNom=request.getParameter("nombre");
			String parametroApe1=request.getParameter("ape1");
			String parametroApe2=request.getParameter("ape2");
		//2.-VALIDAR PARAMENTROS
		
		//3.- LLAMAR MODELO DAO
		
		//4.- ENVIAR ATRIBUTOS VISTA
			request.setAttribute("nombre",parametroNom);	
			request.setAttribute("ape1",parametroApe1);	
			request.setAttribute("ape2",parametroApe2);	
		
			//OTRA FORMA PARA ENVIAR ATRIBUTOS A LA VISTA
			String nombreCompleto=String.format("Nombre completo %s %s %s",parametroNom,parametroApe1,parametroApe2);
			request.setAttribute("nombreCompleto",nombreCompleto);	
		//5.-IR A LA VISTA
		request.getRequestDispatcher("saludo.jsp").forward(request, response);
		
	}
}