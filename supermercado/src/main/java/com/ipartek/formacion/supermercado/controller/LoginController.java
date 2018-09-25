package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.Alert;
import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Implementación de un Controlador Servlet que detecta si un usuario ha sido
 * correctamente logueado, contrastando con la base de datos.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final int TIEMPO_SESION = 60*60*5;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Alert alert = new Alert();
		
		try {
			
			// Recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("psw");
		

			// Comprobar usuario
			if ("admin".equals(pass) && "admin".equals(usuarioNombre)) {

				// Guardar Usuario en session
				Usuario u = new Usuario(usuarioNombre, pass);
				
				// Dar un tiempo de expiración a la sesión
				request.getSession().setMaxInactiveInterval(TIEMPO_SESION);
				
				alert.setTexto("Bienvenido/a. ");
				alert.setTipo(Alert.SUCCESS);

				request.getSession().setAttribute("usuario", u);
			} else {
				
				alert.setTexto("El usuario o la contraseña introducidos no son correctos.");
			}
		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {
			
			request.getRequestDispatcher("listado").forward(request, response);
		}
	}

}
