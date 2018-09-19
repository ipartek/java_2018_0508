package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.UsuariosDAO;
import com.ipartek.formacion.pojo.Alerts;
import com.ipartek.formacion.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean accessSignal = false;
	private static UsuariosDAO usuariosDao;
	private static ArrayList<Usuario> usuarios;
       
    
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		//inicializamos el arraydao de usuarios
		usuariosDao =  usuariosDao.getInstance();
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		usuariosDao = null;
	}
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
		
		Alerts alert = new Alerts();
		HttpSession session = request.getSession();
		
		
		try {
			
			//recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			accessSignal = false;
			//comprobar usuario
			accessSignal = comprobarUsuario(usuarioNombre, pass);
			
			/*if ( "admin".equals(pass) && "admin".equals(usuarioNombre))  {
				
				alert.setTexto("BienVenido " + usuarioNombre );
				alert.setTipo(Alerts.SUCESS);
				
				//guardar Usuario en session
				Usuario u = new Usuario(usuarioNombre, pass);
				
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60*5); // 5min
				
				
			}*/
			if(accessSignal) {
				alert.setTexto("BienVenido " + usuarioNombre );
				alert.setTipo(Alerts.SUCESS);
				
				//guardar Usuario en session
				Usuario usuarioCoincidencia = comprobarUSuarioC(usuarioNombre, pass);
				
				request.setAttribute("usuario", usuarioCoincidencia);
				session.setAttribute("usuario", usuarioCoincidencia);
				session.setMaxInactiveInterval(60*5); // 5min
			}
			else{
				
				alert.setTexto("Credenciales incorrectas" );
				alert.setTipo(Alerts.WARNING);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			//Preguntar en clase diferencia entre sendRedirect y getRequestDispatcher
			//conseguimos tener un url especifica en el navegador
			response.sendRedirect(request.getContextPath() + "/inicio" ); 
		}
		
		
	}
	private Usuario comprobarUSuarioC(String usuarioNombre, String pass) {
		usuarios = (ArrayList<Usuario>) usuariosDao.getAll();
		Usuario usuarioReg = null;
		for (Usuario u : usuarios) {
			if (usuarioNombre.equals(u.getNombre()) && pass.equals(u.getPassword())){
				accessSignal = true;
				usuarioReg = u;
			}
		}
		return usuarioReg;
	}

	private boolean comprobarUsuario(String nombreUsuario, String passUsuario) {
		usuarios = (ArrayList<Usuario>) usuariosDao.getAll();
		for (Usuario u : usuarios) {
			if (nombreUsuario.equals(u.getNombre()) && passUsuario.equals(u.getPassword())){
				accessSignal = true;
			}
		}
		return accessSignal;
	}

}