package com.andrea.perez.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.hibernate.validator.internal.xml.GetterType;

import com.andrea.perez.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Usuario> usuarios = getMockUsers();
		String id = request.getParameter("id");

		if (id == null) {
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
		} else {
			Usuario usuario = new Usuario();
			if (Integer.parseInt(id) > 0) {
				usuario = usuarios.get(Integer.parseInt(id)-1);
			}
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);
		}

		request.setAttribute("usuarios", usuarios);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		String rol = request.getParameter("rol");

		// TODO COMPROBAR SI ES MODIFICAR O CREAR

		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong(id));
		usuario.setNombre(nombre);
		usuario.setContrasena(contrasena);
		usuario.setRol(Integer.parseInt(rol));
		
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);

	}

	private ArrayList<Usuario> getMockUsers() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario u = null;
		for (int i = 1; i < 100; i++) {

			u = new Usuario("nombre" + i, "B12345678");
			u.setId(i);

			if (u.getId() == 1) {
				u.setRol(Usuario.ROL_ADMIN);

			}

			// u.setRol(rol);
			usuarios.add(u);
		}
		return usuarios;

	}

}
