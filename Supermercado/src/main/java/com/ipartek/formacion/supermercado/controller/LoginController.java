package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Usuario;

/**
 * Servlet implementation class LogInController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER = "admin@admin.com";
	private static final String PSWD = "admin123";
	
	private String user = "";
	private String pswd = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("login.jsp").forward(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String view = "login.jsp";
		@SuppressWarnings("unused")
		String msg = "Error inesperado";
		
		try {
			
			//Recoger parametros
			user = request.getParameter("user");
			pswd = request.getParameter("pswd");
			
			if(user.equals(USER) && pswd.equals(PSWD)){
				
				Usuario u = new Usuario(user, pswd);
				
				//Guardar Usuario en session
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60); //1 minuto
				view = "/privado/listado";
				msg = "Bienvenido";
			}else {
				msg = "Credenciales incorrectas";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
//			Con /home pasaria por el controlador. Con /home.jsp no
//			response.sendRedirect(request.getContextPath() + "/home");
			
			//Se limpiaria la url y apareceria /listado en lugar de /login. Limpia la url. 
			//Habria que pasar por parametro el msg porque sino con la redireccion se perderia
			response.sendRedirect(request.getContextPath() + view);
			
			//La url se quedaria en /login aunque vayamos a /listado
//			request.setAttribute("msg", msg);
//			request.getRequestDispatcher(view).forward(request, response);
		}			
	}

}
