package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String ERROR_LOGIN_MSG = "El usuario o la contraseña introducidos son incorrectos.";

	private Alert alert;
	private Usuario usuario;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcces(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcces(request, response);
	}

	private void doProcces(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// Parámetros
			String nombre = (String) request.getParameter("user");
			String psw = (String) request.getParameter("psw");
				
			if ("admin".equals(nombre) && "admin".equals(psw)) {
				// Creamos el alerta de bienvenida
				alert = new Alert("Bienvenido/a " + nombre, Alert.PRIMARY);
				
				// Creamos el objeto Usuario
				usuario = new Usuario(nombre, psw);
				
				// Obtenemos el objeto session
				session = request.getSession();
				
				// Pasamos el usuario 
				session.setAttribute("usuario", usuario);
				
				// Establecemos el máximo tiempo inactivo
				session.setMaxInactiveInterval(60*5); // 5 min.
			
			} else {	// Loguin incorrecto	
				alert = new Alert(ERROR_LOGIN_MSG, Alert.WARNING);
			}
			
		} catch (Exception e) {
			alert = new Alert();
		} finally {	
			session.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

}
