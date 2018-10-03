package com.andrea.perez.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "login.jsp";
		Alert alert=null;

		try {

			// recoger parametros
			String usuario = request.getParameter("usuario");
			String contrasenya = request.getParameter("pass");

			if (comprobarUsuario(usuario, contrasenya)) {

				HttpSession session = request.getSession();
				Usuario u = new Usuario(usuario, contrasenya);

				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(2 * 60 * 60); // 2horas

				view = "inicio";
				alert = new Alert(Alert.ALERT_SUCCESS,"bienvenido " + u.getNombre());;
			} else {
				alert = new Alert(Alert.ALERT_DANGER,"Credenciales Incorrectas, por favor intentalo de nuevo");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}
	}

	public boolean comprobarUsuario(String usuario, String contrasenya) {
		boolean resul = false;

		if ("William".equals(usuario) && "Shakespeare".equals(contrasenya)
				|| "cervantes".equals(usuario) && "saavedra".equals(contrasenya)
				|| "pablo".equals(usuario) && "neruda".equals(contrasenya)
				|| "paulo".equals(usuario) && "cohelo".equals(contrasenya)) {

			resul = true;
		}

		return resul;
	}

}
