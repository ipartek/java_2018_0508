package com.ipartek.formacion.libroElectronicoColaborativo.controller;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libroElectronicoColaborativo.pojo.Alert;
import com.ipartek.formacion.libroElectronicoColaborativo.pojo.Usuario;

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
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Alert alert = new Alert();
		
		try {
			
			//recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			
			Usuario u = new Usuario();
			
			switch(usuarioNombre) {
			case "William":
				if("Shakespeare".equals(pass)) {
					u.setNombre(usuarioNombre);
					u.setPass(pass);
					session.setAttribute("usuario", u);
				}
				break;
			case "cervantes":
				if("saavedra".equals(pass)) {
					u.setNombre(usuarioNombre);
					u.setPass(pass);
					session.setAttribute("usuario", u);
				}
				break;
			case "pablo":
				if("neruda".equals(pass)) {
					u.setNombre(usuarioNombre);
					u.setPass(pass);
					session.setAttribute("usuario", u);
				}
				break;
			case "paulo":
				if("cohelo".equals(pass)) {
					u.setNombre(usuarioNombre);
					u.setPass(pass);
					session.setAttribute("usuario", u);
				}
				break;
			default:
				alert.setTexto("Credenciales incorrectas");
				session.setAttribute("alert", alert);
				request.getRequestDispatcher("login.jsp").forward(request, response);
		}
			
			session.setMaxInactiveInterval(60*5); // 5min
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			response.sendRedirect(request.getContextPath() + "/home" );
		}
	}

}
