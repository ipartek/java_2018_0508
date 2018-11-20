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

import com.ipartek.formacion.youtube.controller.pojo.Alert;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario;
	
	private static final String VIEW_INICIO_ADMIN = "/backoffice/inicio";
	private static final String VIEW_INICIO_USER = "/inicio";
	 
    
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
			
			//idiomas @see com.ipartek.formacion.youtube.filter.IdiomaFilter
			String idioma = (String)session.getAttribute("idioma");			
			Locale locale = new Locale( idioma.split("_")[0] , idioma.split("_")[1] );			
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
						
			
			//recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			Usuario u = new Usuario(usuarioNombre, pass);
			daoUsuario = UsuarioDAO.getInstance();	
			
			 
			
			if (  daoUsuario.login(u) != null ) {
				
				alert.setTexto(MessageFormat.format(idiomas.getString("msj.bienvenida"), usuarioNombre) );
				alert.setTipo(Alert.PRIMARY);
				
				//guardar Usuario en session				
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60*60*60); // 5min				
				
				gestionarCookies(request, response, u);
				
				if ( u.getRol().getId() == Rol.ROL_ADMIN ) {
					view = VIEW_INICIO_ADMIN;
				}
				
				
			}else{
				
				alert.setTexto("Credenciales incorrectas" );
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);			
			response.sendRedirect(request.getContextPath() + view ); 
		}
		
		
	}

	private void gestionarCookies(HttpServletRequest request, HttpServletResponse response, Usuario u) {
		
		String recordar = (String)request.getParameter("recuerdame");
		Cookie cNombre = new Cookie("cNombre", u.getNombre());
				
		if ( recordar != null) {
			
			cNombre.setMaxAge(60*60*24*30*3); // 3meses
			
		}else {
			cNombre.setMaxAge(0); // No guardar
		}
		
		response.addCookie(cNombre);
		
		
	}

}