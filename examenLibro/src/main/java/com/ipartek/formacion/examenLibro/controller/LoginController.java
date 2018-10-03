package com.ipartek.formacion.examenLibro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examenLibro.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> usuarios = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarios = new ArrayList<>();

		Usuario u1 = new Usuario("William ", "Shakespeare");
		Usuario u2 = new Usuario("cervantes", "saavedra");
		Usuario u3 = new Usuario("pablo", "neruda");
		Usuario u4 = new Usuario("paulo", "cohelo");

		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("pass");
		String recordar = request.getParameter("recuerdame");

		for (int i = 0; i < usuarios.size(); i++) {
			Usuario u = usuarios.get(i);

			if (u.getNombre().equals(usuario)) {
				if (u.getPassword().equals(password)) {
					request.getSession().setAttribute("usuario", u);
					if ("on".equals(recordar)) {
						Cookie c = new Cookie("nomUsuario", usuario);

						c.setMaxAge(60 * 60 * 24 * 365);

						response.addCookie(c);
					} else {
						Cookie cookies[] = request.getCookies();

						for (Cookie c : cookies) {
							if ("nomUsuario".equals(c.getName())) {
								c.setMaxAge(0);

								response.addCookie(c);
							}
						}
					}
					break;
				}
				break;
			}
		}

		response.sendRedirect("home");
	}

}
