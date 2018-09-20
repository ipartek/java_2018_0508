package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alert alert = new Alert();
		HttpSession session = request.getSession();
		
		try {
			
			//recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			String recuerda = request.getParameter("recuerdame");
			
			//TODO Que tambien se quede marchado el check
			Cookie cRecuerda = new Cookie("cRecuerda", "5");
			
			if("1".equals(recuerda)) {
				cRecuerda.setValue(usuarioNombre);
			}else {
				cRecuerda.setValue("");
			}
			
			response.addCookie(cRecuerda);
			
			Usuario u = new Usuario();
			
			switch(usuarioNombre) {
				case "admin":
					if("admin".equals(pass)) {
						alert.setTexto("BienVenido " + usuarioNombre );
						alert.setTipo(Alert.PRIMARY);
					
						//guardar Usuario en session
						u.setNombre(usuarioNombre);
						u.setPass(pass);
						session.setAttribute("usuario", u);
					}
					break;
				case "pepe":
					if("pepe".equals(pass)) {
						alert.setTexto("BienVenido " + usuarioNombre );
						alert.setTipo(Alert.PRIMARY);
					
						//guardar Usuario en session
						u.setNombre(usuarioNombre);
						u.setPass(pass);
						session.setAttribute("usuario", u);
					}
					break;
				case "manoli":
					if("manoli".equals(pass)) {
						alert.setTexto("BienVenido " + usuarioNombre );
						alert.setTipo(Alert.PRIMARY);
					
						//guardar Usuario en session
						u.setNombre(usuarioNombre);
						u.setPass(pass);
						session.setAttribute("usuario", u);
					}
					break;
				case "josepo":
					if("josepo".equals(pass)) {
						alert.setTexto("BienVenido " + usuarioNombre );
						alert.setTipo(Alert.PRIMARY);
					
						//guardar Usuario en session
						u.setNombre(usuarioNombre);
						u.setPass(pass);
						session.setAttribute("usuario", u);
					}
					break;
				default:
					alert.setTexto("Credenciales incorrectas");
			}
			
			
			session.setMaxInactiveInterval(60*5); // 5min
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
		
		
	}

}
