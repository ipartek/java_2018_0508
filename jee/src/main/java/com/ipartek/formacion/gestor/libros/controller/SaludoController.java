package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoController
 */
@WebServlet("/saludo")
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch=null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("pasamos por SaludoCOntroller doGet");
		// recibir parametro
		String nombre = request.getParameter("nombre");
		String ape1 = request.getParameter("ape1");
		String ape2 = request.getParameter("ape2");

		//Enviar atributos
		String nombreCompleto=String.format("nombre completo %s %s %s", nombre, ape1,ape2);
		request.setAttribute("nombreCompleto", nombreCompleto);

		// Ir a la vista
		request.getRequestDispatcher("saludo.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	try {
		String nombre = request.getParameter("nom");
		//dispatch=request.getRequestDispatcher(path);
		if (nombre!=null && "".equals(nombre.trim())) {
			request.setAttribute("nombreCompleto", nombre+"envio por POST");
			request.getRequestDispatcher("saludo.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg", "Por favor rellena el nombre y no seas cafre");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		doGet(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		dispatch.forward(request, response);
	}
		
	}

}
