package com.ipartek.formacion.txakur.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.txakur.pojo.Usuario;
import com.ipartek.formacion.txakur.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NOMBRE_USUARIO = "scobby";
	private static final String PASS_USUARIO = "galletas";
	private Alert alert;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String view = "/login.jsp";
		
		try {
			
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			
			Usuario u = new Usuario(nombre, pass);
			
			if(NOMBRE_USUARIO.equals(u.getNombre()) && PASS_USUARIO.equals(u.getPass())) {
				
				alert = new Alert(Alert.SUCCESS, "Bienvenido " + u.getNombre());
				session.setAttribute("alert", alert);
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60*60*24); // 1 día
				view = "/backoffice/home";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
			session.setAttribute("alert", alert);
			
		}finally {
			response.sendRedirect(request.getContextPath() + view);
			
		}
		
	}

}
