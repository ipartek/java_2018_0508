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
		ArrayList<Usuario>usuarios= getMockUsers();
		
		String id = request.getParameter("id");
		if (id==null) {
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
		} else {
			Usuario usuario= new Usuario();
			if (Integer.parseInt(id)>=0) {
				usuario= usuarios.get(Integer.parseInt(id));
				
			}
			
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoger parametros del formulario
		
		String id= request.getParameter("id");
		String nombre= request.getParameter("nombre");
		String pass= request.getParameter("pass");
		String rol= request.getParameter("rol");
		
		//TODO comprobar si es crear o modificar y llamar DAO
		
		
		
		
		
		Usuario usuario= new Usuario();
		usuario.setId(Long.parseLong(id));
		usuario.setNombre(nombre);
		usuario.setPass(pass);
		usuario.setRol(Integer.parseInt(rol));
		
		
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);

	}

	private ArrayList<Usuario> getMockUsers(){
		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
		Usuario u =null;
		
		for (int i = 0; i < 100; i++) {
			 u = new Usuario("nombre"+i, "12345");
			 u.setId(i);
			 usuarios.add(u);
			
		}
		
		
		return usuarios;
		
		
		
	}
}
