package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.HashMap;

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
		Alert alert = null;
		try {

			String nombre = (String) request.getParameter("usuario");
			String contrasenya = (String) request.getParameter("pass");

			if (comprobarCredenciales(nombre, contrasenya)) {
				
				session.setAttribute("usuario", new Usuario(nombre, contrasenya));
				session.setMaxInactiveInterval(60);

			} else {
				alert = new Alert("Usuario o contraseña incorrectos", Alert.DANGER);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Ir a la vista
			session.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/inicio");
		}

	}

	private boolean comprobarCredenciales(String nombre, String contrasenya) {

		boolean existe = false;

		HashMap<String, String> listaUsuarios = new HashMap<String, String>();
		listaUsuarios.put("admin", "admin");
		listaUsuarios.put("pepe", "pepe");
		listaUsuarios.put("manoli", "manoli");
		listaUsuarios.put("josepo", "josepo");

		for (HashMap.Entry<String, String> uCredenciales : listaUsuarios.entrySet()) {
			if (uCredenciales.getKey().equals(nombre) && uCredenciales.getValue().equals(contrasenya)) {
				existe = true;
			}
		}

		return existe;
	}

}
