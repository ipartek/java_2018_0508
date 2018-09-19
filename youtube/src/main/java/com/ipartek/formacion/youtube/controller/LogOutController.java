package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.pojo.Alerts;
import com.ipartek.formacion.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet en logoutcontroller");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("depost en logoutcontroller");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		try {
			if(session != null) {
				//para borrar los usuarios de la sesion 
				session.removeAttribute("usuario");
				session.invalidate();
				session = null;
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			/*request.getRequestDispatcher("home.jsp").forward(request, response);*/
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
		
		
	}

}