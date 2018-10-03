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
@WebServlet(description = "Para la gestion de usuarios", urlPatterns = { "/backoffice/usuario" })
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			Usuario u = null;
			for (int i = 1; i <= 100; i++) {
				
				u = new Usuario("nombre"+i, "contrasenya"+i);
				u.setId(i);
				u.setRol(1);
				usuarios.add(u);
				
			}
			String id = request.getParameter("id");
			if (id == null) {
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("usuario/index.jsp").forward(request, response);
			}else {
				u = new Usuario();
				if (Integer.parseInt(id)>0) {
					u = usuarios.get(Integer.parseInt(id));
				}
				request.setAttribute("usuario", u);
				request.getRequestDispatcher("usuario/form.jsp").forward(request, response);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String contrasenya = request.getParameter("contrasenya");
			String rol = request.getParameter("rol");
			
			//TODO comprobar si es UPDATE o INSERT
			Usuario u = new Usuario();
			u.setId(Long.parseLong(id));
			u.setNombre(nombre);
			u.setContrasenya(contrasenya);
			u.setRol(Integer.parseInt(rol));
			
			request.setAttribute("usuario", u);
			request.getRequestDispatcher("usuario/form.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
