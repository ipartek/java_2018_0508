package com.ipartek.examen.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.examen.model.pojo.Alerts;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/login" })

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean flag = false;
	Alerts alerta = new Alerts();

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
			if (comprobarUSuario(nombreUsuario, passUsuario, session)) {
				session.setMaxInactiveInterval(60 * 60); // 1 hora
				alerta.setTexto("Bienvenido "+nombreUsuario);
				alerta.setTipo(Alerts.SUCESS);
				request.setAttribute("alerta", alerta);
				request.getRequestDispatcher("/ebookController").forward(request, response);
			}else {
				alerta.setTexto("Usuario no encontrado, intentelo de nuevo o pruebe a registarse");
				alerta.setTipo(Alerts.DANGER);
				request.setAttribute("alerta", alerta);
				request.getRequestDispatcher(
						"/ebookController?alertaLogin=1").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("Error en doProcess *LoginController*");
			e.printStackTrace();
			
		}finally {
			
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
