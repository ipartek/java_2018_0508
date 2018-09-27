package com.ipartek.formacion.libreriaelectronica.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.libreriaelectronica.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String user = "";
	private String pswd = "";
	Map<String, String> listaUsuarios = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		super.init();
		listaUsuarios.put("William", "Shakespeare");
		listaUsuarios.put("Cervantes", "Saavedra");
		listaUsuarios.put("Pablo", "Neruda");
		listaUsuarios.put("Paulo", "Cohelo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String msg = "Ha ocurrido un error";
		String view = "/login.jsp";
		
		try {
			
			//Recoger parametros
			user = request.getParameter("user");
			pswd = request.getParameter("pswd");
			
			//Validar parametros recibidos
			if(!listaUsuarios.isEmpty()) {
				if(listaUsuarios.containsKey(user) && pswd.equals(listaUsuarios.get(user))){
					Usuario u = new Usuario(user, pswd);
					
					//Guardar Usuario en session
					session.setAttribute("usuario", u);
					session.setMaxInactiveInterval(60*60); //1 hora
					
					msg = "Bienvenido " + u.getNombre() + "!";
					
					view = "/home";
				}else {
					msg = "Credenciales incorrectas";
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			response.sendRedirect(request.getContextPath() + view + "?msg=" + msg);
		}	
	}
}
