package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {
	String palabraSecreta="cesar";
	int vidas = 5;

	

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Pasamos por doPost()");

		// 1. Recibir parámetros
		String usuarioLetra = (String) request.getParameter("letraAhorcado");

		// 2. Validar parámetros
		if (usuarioLetra == null) {

			request.setAttribute("msg", "Por favor rellena el nombre y no seas vago.");
			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
			
		} else if (!usuarioLetra.trim().isEmpty()) {
			request.setAttribute("letra", usuarioLetra);
		}

		// 4. Enviar atributos a la Vista
		request.getRequestDispatcher("ahorcado.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String palabraBuscar ="cesar";
		String msg = "";
		try {
			
		
		System.out.println("Pasamos por doGet() +1");

		String usuarioLetra = (String) request.getParameter("letraAhorcado");
		
		if(palabraBuscar.contains(usuarioLetra)) {
			System.out.println("La palabra contiene la letra que has introducido");
			msg = "La palabra contiene la letra que has introducido";
		}else {
			System.out.println("No contiene la letra que has introducido");
			msg = "La palabra no contiene la letra que has introducido";
			
		}
		
	
		request.setAttribute("letraAhorcado", usuarioLetra);
		request.setAttribute("msg", msg);
		request.setAttribute("vidas", vidas);
		

		request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
	}
	 catch (Exception e) {
		// TODO: handle exception
	}

	}
	}
