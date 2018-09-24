package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		try {
			//Recoger parametros
			String correo = (String) request.getParameter("correo");
			String contrasenya = (String) request.getParameter("pass");
			
			if ("admin".equals(correo) && "admin@admin.es".equals(contrasenya)) {
				session.setMaxInactiveInterval(60);
				
			} else {

			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/home");
		}finally {
			
		}
		
		
		

	}
	
	
	/**
	 * Funcion para agregar varios usuarios
	 * @param String nombre, String contrasenya
	 * */
	
	
//	private boolean comprobarCredenciales(String nombre, String contrasenya) {
//
//		boolean existe = false;
//
//		HashMap<String, String> listaUsuarios = new HashMap<String, String>();
//		listaUsuarios.put("admin", "admin");
//		listaUsuarios.put("pepe", "pepe");
//		listaUsuarios.put("manoli", "manoli");
//		listaUsuarios.put("josepo", "josepo");
//
//		for (HashMap.Entry<String, String> uCredenciales : listaUsuarios.entrySet()) {
//			if (uCredenciales.getKey().equals(nombre) && uCredenciales.getValue().equals(contrasenya)) {
//				existe = true;
//			}
//		}
//
//		return existe;
//	}
	
	
	
	

}
