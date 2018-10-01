package com.ipartek.examen.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/login" })

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean flag = false;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Pasa por doGet");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String nombreUsuario = request.getParameter("nombreUsuario");
			String passUsuario = request.getParameter("passUsuario");
			System.out.println(nombreUsuario);
			System.out.println(passUsuario);
			if (comprobarUSuario(nombreUsuario, passUsuario, session)) {
				System.out.println("Autentificacion correcta " + nombreUsuario);
				session.setMaxInactiveInterval(60 * 60); // 1 hora
				request.getRequestDispatcher("/comentariosController").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("Error en doProcess *LoginController*");
			e.printStackTrace();
		}

	}

	private boolean comprobarUSuario(String nombreUsuario, String passUsuario, HttpSession session) {
		/**
		 * Comprobamos que los datos introducidos en el login correspondan a uno de los
		 * usuarios hardcodeados<br>
		 * Si corresponden devolvemos true si no corresponde devolvemos false Si
		 * corresponden los datos tambien guardamos el nombre usuario en la sesion
		 * 
		 */
		flag = false;
		if ("William".contentEquals(nombreUsuario) && "Shakespeare".contentEquals(passUsuario)
				|| "cervantes".contentEquals(nombreUsuario) && "saavedra".contentEquals(passUsuario)
				|| "pablo".contentEquals(nombreUsuario) && "neruda".contentEquals(passUsuario)
				|| "paulo".contentEquals(nombreUsuario) && "cohelo".contentEquals(passUsuario)) {
			session.setAttribute("usuario", nombreUsuario);
			flag = true;
		}

		return flag;

	}

}
