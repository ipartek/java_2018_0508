package com.adriana.prado.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adriana.prado.pojo.Alert;
import com.adriana.prado.pojo.Usuario;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
//		Cookie[] cookies = request.getCookies();
		
		try {
			if(session != null) {
				session.removeAttribute("usuario");
				session.invalidate();
				session = null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//request.setAttribute("alert", new Alert(Alert.ALERT_PRIMARY, "Has cerrado sesión."));
			//request.getRequestDispatcher("/").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/inicio");
		}
	}

}
