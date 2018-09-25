package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Alert;
import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER = "admin";
	private static final String PASS = "admin";
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = "login.jsp";
		String msg = "Error inesperado";
		Alert alert = new Alert();
		
		try {
			
			String nombreUsuario = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			
			if(USER.equals(nombreUsuario) && PASS.equals(pass)) {
				
				HttpSession session = request.getSession();
				
				alert.setTexto("Bienvenido " + nombreUsuario);
				alert.setTipo(Alert.SUCCESS);
				
				Usuario u = new Usuario();
				u.setNombre(nombreUsuario);
				u.setPass(pass);
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60 * 60 * 60); //1minuto
				view = "listado";
				msg = "Ongi etorri " + u.getNombre();
				
			}else {
				alert.setTexto("Credenciales incorrectas, por favor inténtelo de nuevo.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			request.setAttribute("alert", alert);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
