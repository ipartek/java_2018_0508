package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_INICIO_ADMIN = "/backoffice/inicio";
	private static final String VIEW_INICIO_USER = "/inicio";
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

			request.getLocale().toString();

			String nombre = (String) request.getParameter("usuario");
			String contrasenya = (String) request.getParameter("pass");
			String cookieNombre = (String) request.getParameter("recordar");

			Usuario u = comprobarCredenciales(nombre, contrasenya); 
			if (u!=null) {

				session.setAttribute("usuario", u);

				gestionCookies(request, response, nombre, cookieNombre);

				/*
				 * Locale locale = new Locale("en", "EN"); 
				 * ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", request.getLocale()); 
				 * alert = new Alert("Bienvenido", Alert.SUCCESS);
				 * alert.setTexto(MessageFormat.format(idiomas.getString("msj.bienvenida"),nombre));
				 */
				if (u.getRol() == Usuario.ROL_ADMIN) {
					response.sendRedirect(request.getContextPath() + VIEW_INICIO_ADMIN);
				}else {
					response.sendRedirect(request.getContextPath() + VIEW_INICIO_USER);
				}
				
				
			} else {
				alert = new Alert("Usuario o contraseña incorrectos.Si aun no se a registrado, <a href='registroUsuario.jsp'> registrese.:D</a>", Alert.DANGER);
				session.setAttribute("alert", alert);
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Usuario comprobarCredenciales(String nombre, String contrasenya) {

		UsuarioDAO dao = UsuarioDAO.getInstance();
		
		Usuario existe = dao.comprobarUsuario(nombre, contrasenya);

		return existe;
	}

	private void gestionCookies(HttpServletRequest request, HttpServletResponse response, String nombre,
			String cookieNombre) {
		Cookie cookies[] = request.getCookies();
		boolean existe = false;
		int pos = 0;

		if ("on".equals(cookieNombre)) {
			for (int i = 0; i < cookies.length; i++) {
				if ("nombreRecordado".equals(cookies[i].getName())) {
					existe = true;
					pos = i;
				}
			}
			if (existe) {
				cookies[pos].setValue(nombre);
			} else {
				Cookie nombreRecordado = new Cookie("nombreRecordado", nombre);
				nombreRecordado.setMaxAge(-1);
				response.addCookie(nombreRecordado);
			}
		} else {
			for (int i = 0; i < cookies.length; i++) {
				if ("nombreRecordado".equals(cookies[i].getName())) {
					existe = true;
					pos = i;
				}
			}
			if (existe) {
				Cookie nombreRecordado = new Cookie("nombreRecordado", nombre);
				nombreRecordado.setMaxAge(0);
				response.addCookie(nombreRecordado);
			}
		}

		gestionDelLocale();
	}

	private void gestionDelLocale() {
		// TODO Auto-generated method stub

	}

}
