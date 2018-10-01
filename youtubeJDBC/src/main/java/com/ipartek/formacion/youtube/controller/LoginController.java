package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuariosDaoJDBC usuariosJDBC;
	private ArrayList<Usuario> usuarios;
	private Alert alerta;
       
    
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
			
			//idiomas @see com.ipartek.formacion.youtube.filter.IdiomaFilter
			String idioma = (String)session.getAttribute("idioma");			
			Locale locale = new Locale( idioma.split("_")[0] , idioma.split("_")[1] );			
			ResourceBundle idiomas = ResourceBundle.getBundle("idiomas", locale );
						
			
			//recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			comprobarUsuario(usuarioNombre,pass);

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
		
		
	}


	private boolean comprobarUsuario(String usuarioNombre, String pass) {
		boolean resul = false;
		resul =usuariosJDBC.checkByNamePass(usuarioNombre, pass);
		if(resul) {
			resul = true;
		}
		
		return resul;
	}

	private void gestionarCookies(HttpServletRequest request, HttpServletResponse response, Usuario u) {
		
		String recordar = (String)request.getParameter("recuerdame");
		Cookie cNombre = new Cookie("cNombre", u.getNombre());
				
		if ( recordar != null) {
			
			cNombre.setMaxAge(60*60*24*30*3); // 3meses
			
		}else {
			cNombre.setMaxAge(0); // No guardar
		}
		
		response.addCookie(cNombre);
		
		
	}

}
