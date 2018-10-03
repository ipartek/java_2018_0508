package com.andrea.perez.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andrea.perez.model.UsuarioDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Usuario;
import com.andrea.perez.pojo.Video;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/login")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_HOME = "home.jsp";

	// Parametros
	private static String user = "";
	private static String pass = "";
	private static String recordar = "";

	private static UsuarioDAO daoUsuario = null;
	private static ArrayList<Video> videos = null;

	private static final String VIEW_INICIO_ADMIN = "/backoffice/inicio";
	private static final String VIEW_INICIO_USER = "/inicio";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("registro.jsp").forward(request, response);
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
		String view = VIEW_INICIO_USER;// redireccionar las vistas
		try {
			// Locale locale = request.getLocale(); (not empty
			// sessionScope.idioma)?sessionScope.idioma:'es_ES'
			String idioma = (String) session.getAttribute("idioma");
			Locale locale = new Locale(idioma.split("_")[0], idioma.split("_")[1]);
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale);

			user = request.getParameter("user");
			pass = request.getParameter("pswd");
			// recordar = request.getParameter("recordar"); Gestionar las cockies
			

			if (user != null && pass != null) {

				Usuario u = new Usuario(user, pass);
				daoUsuario = UsuarioDAO.getInstance();
				if (daoUsuario.getByNombre(user, pass) != null) {

					u = daoUsuario.getByNombre(user, pass);

					alert = new Alert(Alert.ALERT_PRIMARY,
							MessageFormat.format(idiomas.getString("msj.bienvenida"), user));

					session.setAttribute("usuario", u);
					session.setMaxInactiveInterval(60 * 60);// 1 hora

					if (u.getRol() == Usuario.ROL_ADMIN) {
						view = VIEW_INICIO_ADMIN;
					}

				} else {
					alert = new Alert(Alert.ALERT_WARNING,
							"Credenciales incorrectas. Si aún no estás registrado, hazlo <a href='registro.jsp'>aquí</a>");

				}

			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.setAttribute("alert", alert);
			alert = null;
			// request.getRequestDispatcher("/").forward(request, response);
			response.sendRedirect(request.getContextPath() + view);
		}
	}

	private void gestionarCookies(HttpServletRequest request, HttpServletResponse response, Usuario u) {

		String recordar = (String) request.getParameter("recordar");

		Cookie cNombre = new Cookie("cNombre", u.getNombre());

		if (recordar != null) {

			cNombre.setMaxAge(60 * 60 * 24 * 30 * 3); // 3 meses

		} else {
			cNombre.setMaxAge(0); // No guardar
		}

		response.addCookie(cNombre);
	}
}
