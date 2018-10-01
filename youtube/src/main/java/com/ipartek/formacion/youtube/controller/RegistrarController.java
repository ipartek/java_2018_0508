package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class RegistrarController
 */
@WebServlet("/registrarse")
public class RegistrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UsuarioDAO dao;
    
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
			
			String nombre = request.getParameter("usuario");
			String password = request.getParameter("password");
			
			Usuario u = new Usuario();
			u.setNombre(nombre);
			u.setPass(password);
			u.setRol(1);
			
			if ( dao.insert(u) ) {
				alert = new Alert(Alert.SUCCESS, "Usuario registrado correctamente");
			}else {
				alert = new Alert(Alert.WARNING, "ERROR, no se pudo registrar el usuario.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
	}

}
