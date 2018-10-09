package com.ipartek.formacion.txakuretxea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static final String USER = "scobby";
	private static final String PASS = "galletas";
	
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "login.jsp";
		String msg = "Error Inesperado";
		
		try {			
			
			//recoger parametros
			String usuario = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			
			if ( USER.equals(usuario) && PASS.equals(pass)) {
				
				HttpSession session = request.getSession();
				Usuario u = new Usuario();
				u.setNombre(usuario);
				u.setPass(pass);
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60); //1min				
				
				view = "home";
				msg = "Ongi Etorri";
			}else {
				msg = "Credenciales Incorrectas, por favor intentalo de nuevo";
			}
						
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
