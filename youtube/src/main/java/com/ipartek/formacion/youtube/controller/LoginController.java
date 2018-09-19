package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Implementación de un Controlador Servlet que detecta si un usuario ha sido
 * correctamente logueado, contrastando con la base de datos.
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

		Alert alert = new Alert();
		HttpSession session = request.getSession();

		try {

			// recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");

			// comprobar usuario
			if ("admin".equals(pass) && "admin".equals(usuarioNombre)) {

				alert.setTexto("BienVenido " + usuarioNombre);
				alert.setTipo(Alert.PRIMARY);

				// guardar Usuario en session
				Usuario u = new Usuario(usuarioNombre, pass);

				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60 * 5); // 5min

			} else {

				alert.setTexto("Credenciales incorrectas");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.setAttribute("alert", alert);
			// request.getRequestDispatcher("home.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/inicio");
		}

	}

}
