package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.Usuario;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
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

			request.getLocale().toString();

			String nombre = (String) request.getParameter("nombre");
			String contrasenya = (String) request.getParameter("pass");

			if (comprobarCredenciales(nombre, contrasenya)) {

				session.setAttribute("usuario", new Usuario(nombre, contrasenya));
				session.setMaxInactiveInterval(60 * 5);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Ir a la vista
			response.sendRedirect(request.getContextPath() + "/home");
		}

	}

	private boolean comprobarCredenciales(String nombre, String contrasenya) {

		boolean existe = false;

		HashMap<String, String> listaUsuarios = new HashMap<String, String>();
		listaUsuarios.put("William", "Shakespeare");
		listaUsuarios.put("cervantes", "saavedra");
		listaUsuarios.put("pablo", "neruda");
		listaUsuarios.put("paulo", "cohelo");

		for (HashMap.Entry<String, String> uCredenciales : listaUsuarios.entrySet()) {
			if (uCredenciales.getKey().equals(nombre) && uCredenciales.getValue().equals(contrasenya)) {
				existe = true;
			}
		}

		return existe;
	}
}
