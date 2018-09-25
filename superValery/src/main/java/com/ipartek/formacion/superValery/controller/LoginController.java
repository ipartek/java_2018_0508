package com.ipartek.formacion.superValery.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import com.ipartek.formacion.superValery.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER = "admin@admin.com";
	private static final String PASS = "12345678";
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "login.jsp";
		String msg = "error Inesperado";
		try {
			
			//recoger parametros
			String correo = request.getParameter("correo");
			String pass = request.getParameter("pass");
			
			if(USER.equals(correo) && PASS.equals(pass)) {
				
				HttpSession session = request.getSession();
				Usuario u = new Usuario();
				u.setNombre(correo);
				u.setPass(pass);
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60);//1 minuto
				 view = "privado/listado-producto.jsp";
				 msg = "Ongi Etorri";
			}else {
				msg = "Credenciales incorrectas, por favor intentalo de nuevo";
			}

		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(view).forward(request, response);
			
		}
	}

}
