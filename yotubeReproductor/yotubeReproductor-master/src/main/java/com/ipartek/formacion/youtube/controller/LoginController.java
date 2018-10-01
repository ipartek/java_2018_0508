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


import com.ipartek.formacion.youtube.Alert;
import com.ipartek.formacion.youtube.Usuario;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
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
	
		
		try {
			
			//idiomas
			String idioma = (session.getAttribute("idioma")!=null)?(String)session.getAttribute("idioma"):"es_ES";			
			//Locale locale = new Locale("en", "EN");
			Locale locale = new Locale( idioma.split("_")[0] , idioma.split("_")[1] );			
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
		
			
			//recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			String recordar = request.getParameter("recordar");
			
			//comprobar usuario
			if ( "admin".equals(pass) && "admin".equals(usuarioNombre) || "pepe".equals(pass) && "pepe".equals(usuarioNombre) || "manoli".equals(pass) && "manoli".equals(usuarioNombre) || "josepo".equals(pass) && "josepo".equals(usuarioNombre) )  {
				

				alert.setTexto(  MessageFormat.format(idiomas.getString("msj.bienvenida"), usuarioNombre) );
				
				alert.setTipo(Alert.PRIMARY);
				
				//guardar Usuario en session
				Usuario u = new Usuario(usuarioNombre, pass);
				
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60*5); // 5min
				
				if("recordar".equals(recordar)) {
					Cookie c = new Cookie("nomUsuario", usuarioNombre);
					
					c.setMaxAge(60*60*24*365);
					
					response.addCookie(c);
				}else {
					Cookie cookies[] = request.getCookies();
					
					for(Cookie c: cookies) {
						if("nomUsuario".equals(c.getName())) {				
							c.setMaxAge(0);
							
							response.addCookie(c);
						}
					}
				}
				
			}else{
				
				alert.setTexto("Credenciales incorrectas" );
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
		
		
	}

}