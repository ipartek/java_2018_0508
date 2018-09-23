package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		try {

			// Recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");

			// Comprobar usuario
			if ("admin".equals(pass) && "admin".equals(usuarioNombre)) {

				Locale locale = request.getLocale();
			    ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale);
			    
			    // Mensaje de idiomas con parámetro (usuarioNombre)
			    alert.setTexto(  MessageFormat.format(idiomas.getString("msj.bienvenida"), usuarioNombre) );
				alert.setTipo(Alert.PRIMARY);

				// Guardar Usuario en session
				Usuario u = new Usuario(usuarioNombre, pass);
				
				gestionarSesionDeUsuario(request, u);
				gestionarCookiesDeUsuario(request, response, u);
				

			} else {

				alert.setTexto("Credenciales incorrectas");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getSession().setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/inicio");
		}

	}

	private void gestionarSesionDeUsuario(HttpServletRequest request, Usuario u) {
		HttpSession session = request.getSession();
		
		session.setAttribute("usuario", u);		
		session.setMaxInactiveInterval(60 * 5); // 5 min
		
	}

	private void gestionarCookiesDeUsuario(HttpServletRequest request, HttpServletResponse response, Usuario u) {
		
		String recordar = (String)request.getParameter("recuerdame");
		Cookie cNombre = new Cookie("cNombre", u.getNombre());
				
		if ( recordar != null) {	
			cNombre.setMaxAge(60*60*24*30*3); // 3 meses	
		}else {
			cNombre.setMaxAge(0); // No guardar
		}
		
		setCookieIdioma(request, response);
		response.addCookie(cNombre);	
	}
	
	/**
	 * Procedimiento que gestiona la cookie del idioma.
	 * @param request
	 * @param response
	 */
	private void setCookieIdioma(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie cIdioma = new Cookie ("cIdioma", request.getLocale().toString());
		cIdioma.setMaxAge(60*60*24*30);	// 1 mes
		
		response.addCookie(cIdioma);
	}
	
	

}
