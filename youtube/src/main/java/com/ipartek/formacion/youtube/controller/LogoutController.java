package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.pojo.Alert;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String LOGOUT_MSG = "Gracias por su visita. Esperamos verle de nuevo pronto.";
	
	private HttpSession session;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces(request, response);
	}
	
	private void doProcces(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			//	Capturamos la session
			session = request.getSession();
			
			//	Cerramos la session
			session.invalidate();
			session = null;
			System.out.println("Sesion cerrada");
			new Alert(LOGOUT_MSG, Alert.PRIMARY);
		
		} catch (Exception e) {		
			session.setAttribute("alert", new Alert());
		} finally {
			response.sendRedirect(request.getContextPath() + "/");
		}
		
	}

}
