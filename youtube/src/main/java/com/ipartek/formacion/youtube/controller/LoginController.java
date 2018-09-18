package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
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
		
		try {
			
			String nombre = (String) request.getParameter("usuario");
			String contrasenya = (String) request.getParameter("pass");
			nombre.charAt(9);
			if ("admin".equals(nombre) && "admin".equals(contrasenya) ) {
				HttpSession session = request.getSession();
				session.setAttribute("usuario", new Usuario(nombre, contrasenya));
				session.setMaxInactiveInterval(60*5);
			}else {
				request.setAttribute("alert", new Alert("Usuario o contraseña incorrectos", Alert.DANGER));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Ir a la vista
			response.sendRedirect(request.getContextPath()+"/inicio");
		}
		
	}

}
