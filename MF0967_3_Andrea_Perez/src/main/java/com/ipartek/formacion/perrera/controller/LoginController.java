package com.ipartek.formacion.perrera.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.perrera.model.Alert;
import com.ipartek.formacion.perrera.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static final String USER = "scobby";
	private static final String PASS = "galletas";
	Alert alert = null;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "home";
		String msg = "Error Inesperado";
		
		try {			
			
			//recoger parametros
			String usuario = request.getParameter("nombreLogin");
			String pass = request.getParameter("passUsuario");
			
			if ( USER.equals(usuario) && PASS.equals(pass)) {
				
				HttpSession session = request.getSession();
				Usuario u = new Usuario();
				
				u.setNombre(usuario);
				u.setContrasenya(pass);
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(365 * 24 * 60 * 60 * 1000); // 1anyo
				//session.setMaxInactiveInterval(60); //1min				
				alert=new Alert(Alert.ALERT_SUCCESS,"Bienvenido <strong>"+ u.getNombre() + "</strong>");
				
			}else {
				alert=new Alert(Alert.ALERT_DANGER,"Credenciales incorrectas");
				
			}
						
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
	}

}
