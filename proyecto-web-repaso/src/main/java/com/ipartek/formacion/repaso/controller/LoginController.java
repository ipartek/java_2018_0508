package com.ipartek.formacion.repaso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.repaso.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LoginController.class);

	private static final String USER = "admin";
	private static final String PASS = "admin";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("entro");
		String view = "lilstado.jsp";

		try {

			// recoger parametros
			String usuario = request.getParameter("usuario");
			String pass = request.getParameter("pass");

			if (USER.equals(usuario) && PASS.equals(pass)) {

				HttpSession session = request.getSession();
				Usuario u = new Usuario();
				u.setNombre(usuario);
				u.setPass(pass);
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60); // 1min

				view = "listado.jsp";
				request.setAttribute("msj", "Usuario correccto");
			} else {
				request.setAttribute("msj", "Credenciales incorrectas");

			}

		} catch (Exception e) {
			request.setAttribute("msj", "Lo sentimos pero se produjo un fallo");
			LOG.error(e);

		} finally {

			request.getRequestDispatcher(view).forward(request, response);
		}
		LOG.trace("salgo");
	}

}
