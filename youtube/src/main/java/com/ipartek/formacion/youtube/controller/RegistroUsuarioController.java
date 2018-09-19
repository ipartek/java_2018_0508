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

import com.ipartek.formacion.model.*;
import com.ipartek.formacion.pojo.Alerts;
import com.ipartek.formacion.pojo.Usuario;





/**
 * Servlet implementation class ListarControler
 */
@WebServlet("/RegistroUsuarioControler")
public class RegistroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuariosDAO usuariosDao;
	private static ArrayList<Usuario> usuarios;
	private String msg;
	private static boolean error = false;
       
    
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
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Antes de realizar GET o POST");
		System.out.println(request.getContextPath());
		
		super.service(request, response);  //llama a los metodos GET o POST
				
		//despues de realizar GET o POST
		if(usuarios != null) {
			request.setAttribute("usuarios", usuarios);
		}
		
		request.setAttribute("usuarios", usuarios);
		//nos vamos a index pasando por el controlador mapeado con inicio limpiado la url
		response.sendRedirect(request.getContextPath() + "/inicio" ); 
		//request.getRequestDispatcher("/inicio").forward(request, response);
		
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***GET***");
		doProcess(request,response);
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***POST***");
		doProcess(request,response);
			
		
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alerts alert = new Alerts();
		try {
			System.out.println("***POST***");
			//recogemos parametros
			String nombreUsuario = request.getParameter("nombreUsuario");
			String passUsuario = request.getParameter("passUsuario");
			String emailUsuario = request.getParameter("emailUsuario");
			String replyPassUsuario = request.getParameter("replyPassUsuario");
			
			usuarios =  (ArrayList<Usuario>) usuariosDao.getAll();
			HttpSession session = request.getSession();
			
			long id = 0;
			
			//validamos
			
			boolean errorPassReg = comprarUsuarioPassReg(passUsuario,replyPassUsuario);
			boolean errorNombre = comprobarUsuarioNombrel(nombreUsuario);
			boolean errorEmail = comprobarUsuarioEmail(emailUsuario);
			
			if (errorPassReg || errorNombre || errorEmail) {
				error= true;
				
				request.setAttribute("msg", msg);
				alert.setTexto(msg);
				alert.setTipo(Alerts.DANGER);
				session.setAttribute("alert", alert);
				
				
			}else {
				id = getIdOnDao();
				Usuario nuevoUsuario = new Usuario(id,nombreUsuario,emailUsuario,passUsuario);
				usuariosDao.insert(nuevoUsuario);
				session.setAttribute("usuario", nuevoUsuario);
				session.setMaxInactiveInterval(60*5); // 5min
				request.setAttribute("nombre", nombreUsuario);
				alert.setTexto("BienVenido " + nombreUsuario );
				alert.setTipo(Alerts.SUCESS);
				session.setAttribute("alert", alert);
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			/*alert.setTexto(msg);
			request.setAttribute("error", error);
			request.getRequestDispatcher("index.jsp").forward(request, response);*/
		}
		
	}

	private long getIdOnDao() {
		return usuarios.size()+1;
	}

	private boolean comprarUsuarioPassReg(String passUsuario, String replyPassUsuario) {
		
		if(passUsuario.contentEquals(replyPassUsuario) && replyPassUsuario.contentEquals(passUsuario)) {
			error = false;
		}
		else {
			error = true ;
			msg = "Error revisa las contraseñas introducidas";
		}
		return error;
	}

	private boolean comprobarUsuarioNombrel(String nombreUsuario) {
		if(usuarios.size() > 0) {
			for (Usuario u : usuarios) {
				if ( nombreUsuario.equals( u.getNombre() ) ){
					error = true;
					msg = "Error intentelo con otro nombre de usuario";
				}
			}
			
		}
		return error;
	}

	private boolean comprobarUsuarioEmail( String emailUsuario) {
		
		if(usuarios.size() > 0) {
			for (Usuario u : usuarios) {
				if ( emailUsuario.equals( u.getEmail() ) ){
					error = true;
					msg = "Ya tenemos un usuario con esta direcion de correo";
				}
			}
			
		}
		return error;
		
	}

}
