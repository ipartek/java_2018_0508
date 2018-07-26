package com.ipartek.formacion.gestor.libros.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") // La url a la que hay que escuchar, SIEMPRE empieza por barra( / )
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_VIEW = "login.jsp";
	private static final String SALUDO_VIEW = "saludo.jsp";
	private RequestDispatcher dispatch = null;
	
	private static final String USUARIO_CORRECTO = "admin";
	private static final String PASSWORD_CORRECTA = "1234";
	private static String msgBienvenida = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			dispatch = request.getRequestDispatcher(LOGIN_VIEW);
			
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("pass");
			
			request.setAttribute("msgIncorrecto", "");
						
			if((usuario != null && !"".equals(usuario)) || (password != null && !"".equals(password))) {
				
				request.setAttribute("usuarioEscrito", usuario);
				request.setAttribute("passEscrita", password);
								
			}
			
			if(USUARIO_CORRECTO.equals(usuario) && PASSWORD_CORRECTA.equals(password)) {
				dispatch = request.getRequestDispatcher(SALUDO_VIEW);
				msgBienvenida = "Bienvenido " + usuario;
			
			}
			if(usuario == null) {
				request.setAttribute("msgIncorrecto", "");
			}else {
				request.setAttribute("msgIncorrecto", "Las credenciales no son correctas");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			request.setAttribute("msgBienvenida", msgBienvenida);
			dispatch.forward(request, response);
		}

	}
}
