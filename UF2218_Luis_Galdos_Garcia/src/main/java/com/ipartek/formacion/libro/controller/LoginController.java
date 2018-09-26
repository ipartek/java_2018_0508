package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libro.pojo.Alert;
import com.ipartek.formacion.libro.pojo.Usuario;

/**
 * Servlet para gestionar el inicio de sesión del usuario.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final HashMap<String, Usuario> USUARIOS_AUTORIZADOS = cargarUsuarios();
	
	Alert alert;
	Usuario u;
	
	private static HashMap<String, Usuario> cargarUsuarios() {
		
		HashMap<String, Usuario> usuarios = new HashMap<>();
		
		Usuario u = new Usuario("william", "shakespeare");
		usuarios.put(u.getNombre(), u);
		
		u = new Usuario("pablo", "neruda");
		usuarios.put(u.getNombre(), u);
		
		u = new Usuario("cervantes", "saavedra");
		usuarios.put(u.getNombre(), u);
		
		u = new Usuario("paulo", "cohelo");
		usuarios.put(u.getNombre(), u);
		
		return usuarios;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			alert = new Alert();	// Creamos la alerta por defecto
			
			if (validarUsuario(request)) { // Si el usuario es correcto

				gestionarVariablesDeSesion(request, u);
				gestionarCookiesDeUsuario(request, response, u);
				
			} else { // Usuario no correcto

				alert.setTexto("Credenciales incorrectas");
			}
		} catch (Exception e) { // Capturamos cualquier excepción
			e.printStackTrace();

		} finally { // Volvemos a la vista 'index.jsp' enviando el mensaje correspondiente.

			request.getSession().setAttribute("alert", alert);
			request.getRequestDispatcher("inicio?numPagina=1").forward(request, response);
		}
	}

	/**
	 * Procedimiento privado para comprobar si el usuario y la contraseña introducidos son
	 * correctos.
	 * 
	 * @param request, HttpServletRequest
	 * @return true <=> usuario = admin & psw = admin
	 */
	private boolean validarUsuario(HttpServletRequest request) {
		boolean correcto = false;

		// Recoger parametros
		String usuarioNombre = request.getParameter("usuario");
		String psw = request.getParameter("password");
		
		Usuario user = USUARIOS_AUTORIZADOS.get(usuarioNombre);

		if (user.getNombre().equals(usuarioNombre) && user.getPass().equals(psw)) { // Comprobar usuario

			alert.setTexto("Bienvenido/a " + usuarioNombre);
			alert.setTipo(Alert.SUCCESS);

			u = new Usuario(usuarioNombre, psw); // Creamos el Usuario
			correcto = true;
		}
		return correcto;
	}

	/**
	 * Procedimiento privado para almacenar en una cookie el Usuario logueado si el campo
	 * recordar está checked.
	 * 
	 * @param request, HttpServletRequest
	 * @param response,HttpServletRequest
	 * @param u, Usuario
	 */
	private void gestionarCookiesDeUsuario(HttpServletRequest request, HttpServletResponse response, Usuario u) {

		String recordar = (String) request.getParameter("recordar");
		Cookie cNombre = new Cookie("cNombre", u.getNombre());

		if (recordar != null) { // Recordar usuario está activado
			cNombre.setMaxAge(60 * 60 * 24 * 30 * 3); // 3 meses

		} else {
			cNombre.setMaxAge(0); // No guardar
		}

		response.addCookie(cNombre); // Añadimos la cookie en la response
	}

	/**
	 * Procedimiento privado que guarda en la sesión los Atributos (variables)
	 * necesarios para su gestión.
	 * 
	 * @param request, HttpServletRequest
	 * @param u, Usuario
	 */
	private void gestionarVariablesDeSesion(HttpServletRequest request, Usuario u) {

		HttpSession session = request.getSession();

		session.setAttribute("usuario", u);	// Guardamos el Usuario en la sesión
		session.setMaxInactiveInterval(60 * 5); // 5 min
	}

}
