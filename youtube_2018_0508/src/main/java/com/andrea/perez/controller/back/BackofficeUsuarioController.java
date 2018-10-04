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

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == "" o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";
	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMULARIO = "usuarios/form.jsp";

	private String view;
	private String op; // operacion a realizar
	private String id;
	private String nombre;
	private String contrasena;
	private String rol;

	private static UsuarioDAO daoUsuario = null;
	private Alert alert = null;

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

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			getParameters(request);

			switch (op) {
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_IR_FORMULARIO:
				irFormulario(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;

			default:
				listar(request);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	private void listar(HttpServletRequest request) {
		
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", daoUsuario.getAll());

	}

	private void guardar(HttpServletRequest request) {

		Usuario usuario = new Usuario();

		usuario.setNombre(nombre);
		usuario.setContrasena(contrasena);
		usuario.setRol(Integer.parseInt(rol));

		if (!id.equals("")) { // MODIFICAR

			usuario.setId(Long.parseLong(id));

			daoUsuario.update(usuario);
		} else { // INSERT
			daoUsuario.insert(usuario);
		}
		request.setAttribute("usuario", usuario);
		view = VIEW_FORMULARIO;
	}

	private void irFormulario(HttpServletRequest request) {
		Usuario usuario = null;
		if (Integer.parseInt(id) > 0) {
			usuario = daoUsuario.getById(id);
		} else {
			usuario = new Usuario();
		}
		view = VIEW_FORMULARIO;
		request.setAttribute("usuario", usuario);
	}

	private void eliminar(HttpServletRequest request) throws IOException {

		if (id != null) {
			daoUsuario.delete(id);	
			view = VIEW_LISTADO;
			HttpServletResponse response = null;
			response.sendRedirect("view");
		}
	}

	private void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		contrasena = request.getParameter("contrasena");
		rol = request.getParameter("rol");
	}

}
