package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Usuario> usuarios = getMockUsers();
		
		try {
			String id = request.getParameter("id");
			
			if(id == null) {
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
				
			}else {
				Usuario usuario = new Usuario();
				
				if(Integer.parseInt(id) > 0) {
					usuario = usuarios.get(Integer.parseInt(id) - 1);
				}
				
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("usuarios/formulario.jsp").forward(request, response);
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		
		//Recoger parámetros
		try {
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			String rol = request.getParameter("rol");
			
			//TODO comprobar si es CREAR o MODIFICAR y llamar DAO
			usuario.setId(Long.parseLong(id));	
			usuario.setNombre(nombre);
			usuario.setPass(pass);
			usuario.setRol(Integer.parseInt(rol));

			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		
		}finally {
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuarios/formulario.jsp").forward(request, response);
		}
		
	}
	
	private ArrayList<Usuario> getMockUsers() {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = null;
		
		for (int i = 1; i <= 100; i++) {
			u = new Usuario("nombre " + i, "123456");
			if(i == 1) {
				u.setRol(Usuario.ROL_ADMIN);
			}
			u.setId(i);
			usuarios.add(u);
		}
		
		return usuarios;
		
	}

}
