package com.andrea.perez.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.hibernate.validator.internal.xml.GetterType;

import com.andrea.perez.model.ComentarioArrayDAO;
import com.andrea.perez.model.UsuarioDAO;
import com.andrea.perez.model.VideoDAO;
import com.andrea.perez.pojo.Alert;
import com.andrea.perez.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario = null;
	private static ArrayList<Usuario> usuarios = null;
	Alert alert = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// Se ejecuta solo con la primera peticion. El resto van al service
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		// Se ejecuta al parar el servidor
		super.destroy();
		daoUsuario = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuarios = (ArrayList<Usuario>) daoUsuario.getAll();

		String id = request.getParameter("id");

		// el id ==null te lo carga en la tabla los datos
		if (id == null) {
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
		} else {

			Usuario usuario = new Usuario();
			// Si el id -1== te manda al form para crear el usuario...si el id > 0 te coge
			// el usuario de la tabla
			if (Integer.parseInt(id) > 0) {
				int temp = (int) usuario.getId();
				usuario = daoUsuario.getById(id);
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
		boolean resul = false;
		// Modificar usuario
		if ("1".equals(id)) {
			usuario.setId(Long.parseLong(id));
			usuario.setNombre(nombre);
			usuario.setContrasena(contrasena);
			usuario.setRol(Integer.parseInt(rol));

			resul = daoUsuario.update(usuario);
			if (daoUsuario.update(usuario)) {

			} else {

			}
		} else if ("-1".equals(id)) {// delete

		}

		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuarios/form.jsp").forward(request, response);

	}

}
