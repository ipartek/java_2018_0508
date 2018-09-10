package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	String NOMBRE = "Raul" ;
	String PASSWORD = "Contrasena";
	String msgLogin;

	

	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// Logger.getLogger(PrestamosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		/*
		 * System.out.println("Pasamos por doPost()");
		 * 
		 * // 1. Recibir parámetros String usuarioLetra = (String)
		 * request.getParameter("letraAhorcado");
		 * 
		 * // 2. Validar parámetros if (usuarioLetra == null) {
		 * 
		 * request.setAttribute("msg", "Por favor rellena el nombre y no seas vago.");
		 * request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		 * 
		 * } else if (!usuarioLetra.trim().isEmpty()) { request.setAttribute("letra",
		 * usuarioLetra); }
		 * 
		 * // 4. Enviar atributos a la Vista
		 * request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		 */

	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doPost( request, response);
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			String usuarioNombre = (String) request.getParameter("nombre");
			String usuarioPassword = (String) request.getParameter("contrasena");
			System.out.println(usuarioNombre);
			System.out.println(usuarioPassword);
			if(usuarioNombre.equals(NOMBRE) && usuarioPassword.equals(PASSWORD) ) {
				msgLogin = "Las credenciales son correctas redireccionamiento en curso a saludo.jsp";
				request.setAttribute("msg",msgLogin);
				request.setAttribute("nombre",usuarioNombre);
				request.setAttribute("apellido1",usuarioPassword);
				request.getRequestDispatcher("saludo.jsp").forward(request, response);
			}else {
				msgLogin = "Las credenciales no son correctas ";
				request.setAttribute("msg",msgLogin);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



	

	
			
			
		
	
	

	
	
}
