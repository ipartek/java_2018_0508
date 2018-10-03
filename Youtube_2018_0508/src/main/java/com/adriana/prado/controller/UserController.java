package com.adriana.prado.controller;

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

import com.adriana.prado.model.UsuarioDAO;
import com.adriana.prado.pojo.Alert;
import com.adriana.prado.pojo.Usuario;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/login")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_INICIO_ADMIN = "/backoffice/inicio";
	private static final String VIEW_INICIO_USER = "/inicio";
	
	//Parametros
	private static String user = "";
	private static String pswd = "";
	private static String recordar = "";
	
	private static UsuarioDAO daoUsuario;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alert alert = new Alert();
		HttpSession session = request.getSession();
		String view = VIEW_INICIO_USER;
		
		try {
			//Locale locale = request.getLocale(); (not empty sessionScope.idioma)?sessionScope.idioma:'es_ES'
			String idioma = (String)session.getAttribute("idioma");
			Locale locale = new Locale(idioma.split("_")[0], idioma.split("_")[1]);
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
			
			user = request.getParameter("user");
			pswd = request.getParameter("pswd");
			recordar = request.getParameter("recordar");
			
			
			//Comprobar usuario contra BBDD
			daoUsuario = UsuarioDAO.getInstance();
			
			Usuario usuario = daoUsuario.getByNombre(user, pswd);
			
			if(/*usuario.getNombre().equals(user) && usuario.getContrasena().equals(pswd)*/ usuario != null){
				alert = new Alert(Alert.ALERT_PRIMARY, MessageFormat.format(idiomas.getString("msj.bienvenida"),user));
				
				//Usuario u = new Usuario(user, pswd);
				
				if(usuario.getRol() == Usuario.ROL_ADMIN) {
					view = VIEW_INICIO_ADMIN;
				}else {
					view = VIEW_INICIO_USER;
				}
				
				//Guardar Usuario en session
				session.setAttribute("usuario", usuario);
				session.setMaxInactiveInterval(60*5); //5 minutos
				
				//Gestionar cookies
				gestionarCookies(request, response, usuario);
			}else {
				alert = new Alert(Alert.ALERT_WARNING, "Credenciales incorrectas. Si aún no estás registrado, hazlo <a href='registro.jsp'>aquí</a>");
			}
			
			session.setAttribute("alert", alert);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
//			session.setAttribute("alert", alert);
			alert = null;
			//request.getRequestDispatcher("/").forward(request, response);
			response.sendRedirect(request.getContextPath() + view);
		}	
	}



	private void gestionarCookies(HttpServletRequest request, HttpServletResponse response, Usuario u) {
		
		String recordar = (String)request.getParameter("recordar");
		
		Cookie cNombre = new Cookie("cNombre", u.getNombre());
		
		if(recordar != null) {
			
			cNombre.setMaxAge(60*60*24*30*3); //3 meses
			
		}else{
			cNombre.setMaxAge(0); //No guardar
		}
		
		response.addCookie(cNombre);
	}
}
