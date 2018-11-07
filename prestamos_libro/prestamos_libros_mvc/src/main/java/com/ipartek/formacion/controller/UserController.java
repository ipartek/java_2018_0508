package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.pojo.Alert;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/login")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parametros
	private static final String USER = "ander";
	private static final String PASS = "12345";

	private static final String VIEW_INICIO_USER = "/prestamo/home";
	private static final String VIEW_LOGIN = "/login.jsp";
	
	private String view = "";
	private Alert alert = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		view = VIEW_LOGIN;// redireccionar las vistas

		HttpSession session = request.getSession();

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		try {
			if (user != null && pass != null && user.equals(USER)&& pass.equals(PASS)) {
				
				session.setAttribute("user", user);
				session.setAttribute("pass", pass);
				session.setMaxInactiveInterval(60 * 60);// 1 hora
				
				view=VIEW_INICIO_USER;
				
				alert = new Alert(Alert.ALERT_SUCCESS, "Bienvenido " + user);
				
			}else {
				alert = new Alert(Alert.ALERT_DANGER, "Credenciales incorrectas");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			view= VIEW_LOGIN;
			alert = new Alert(Alert.ALERT_DANGER, "Ha ocurrido un error no controlado.");
		}finally {
//			request.getRequestDispatcher(view).forward(request, response);
			session.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + view);
		}

		
	}

}
