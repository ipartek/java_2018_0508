package com.adriana.prado.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adriana.prado.pojo.Alert;
//import com.adriana.prado.model.UsuarioDAO;
import com.adriana.prado.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private static UsuarioDAO daoUsuario;
	
	private static final String VIEW_FORM_USUARIOS = "usuarios/form.jsp";
	private static final String VIEW_INDEX_USUARIOS = "usuarios/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		daoUsuario = UsuarioDAO.getInstance();
		//try catch y mensajes para el usuario
		ArrayList<Usuario> usuarios = getMockUsers();
		
		String id = request.getParameter("id");
		
		try {
			if(id == null) {
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher(VIEW_INDEX_USUARIOS).forward(request, response);
			}else {
				Usuario usuario = new Usuario();
				if(Integer.parseInt(id)>0) {
					usuario = usuarios.get(Integer.parseInt(id)-1);
				}
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher(VIEW_FORM_USUARIOS).forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alert alert = new Alert();
		
		//Recoger parametros
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		String rol = request.getParameter("rol");
		
		try {
			//TODO Realizar comprobaciones pertinentes
			//TODO Comprobar si es crear o modificar y llamar al DAO
			
			Usuario usuario = new Usuario();
			usuario.setId(Long.parseLong(id));
			usuario.setNombre(nombre);
			usuario.setContrasena(contrasena);
			usuario.setRol(Integer.parseInt(rol));
			
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(VIEW_FORM_USUARIOS).forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private ArrayList<Usuario> getMockUsers(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		for(int i=1;i<=100;i++) {
			Usuario u = new Usuario("nombre"+i, "123456");
			u.setId(i);
			if(u.getId() == 1) {
				u.setRol(Usuario.ROL_ADMIN);
			}
			usuarios.add(u);
		}
		return usuarios;
	}
}
