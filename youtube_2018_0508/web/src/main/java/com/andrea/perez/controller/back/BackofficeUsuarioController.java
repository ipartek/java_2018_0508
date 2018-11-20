package com.andrea.perez.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrea.perez.controller.pojo.Alert;
import com.andrea.perez.model.RolDAO;
import com.andrea.perez.model.UsuarioDAO;
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
	private Alert alert = null;

	private String op; // parametros necesarios
	private String id;
	private String nombre;
	private String contrasena;
	private String rol;

	private static UsuarioDAO daoUsuario = null;
	private static RolDAO daoRol = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// Se ejecuta solo con la primera peticion. El resto van al service
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoRol = RolDAO.getInstance();
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

	private void listar(HttpServletRequest request) throws Exception {

		view = VIEW_LISTADO;
		request.setAttribute("usuarios", daoUsuario.getAll());

	}

	private void guardar(HttpServletRequest request) {

		Usuario usuario = new Usuario();

		usuario.setNombre(nombre);
		usuario.setContrasena(contrasena);

		try {
			if (rol != null) {
				//usuario.setRol(daoRol.getById(rol));
				
			}

			if (!id.equals("")) { // MODIFICAR

				usuario.setId(Long.parseLong(id));

				if (daoUsuario.update(usuario)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Usuario modificado correctamente");
				}
			} else if (daoUsuario.insert(usuario)) { // Insertar
				alert = new Alert(Alert.ALERT_SUCCESS, "Usuario registrado correctamente");
			}
			request.setAttribute("roles", daoRol.getAll());
			// nombre repetido
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			alert = new Alert(Alert.ALERT_WARNING, "<b>" + usuario.getNombre() + " ya existe!!");

		} catch (SQLException e) { // Longitud nombre o pass mas largo de lo debido

			if (e.getMessage().contains("nombre")) {
				alert = new Alert(Alert.ALERT_WARNING,
						" superado  el maximo de caracteres permitido(50) para el nombre");
			} else if (e.getMessage().contains("password")) {
				alert = new Alert(Alert.ALERT_WARNING,
						" superado  el maximo de caracteres permitido(20) para la contraseña");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// alert = new Alert();
		}

		request.setAttribute("usuario", usuario);
		
		
		view = VIEW_FORMULARIO;

	}

	private void irFormulario(HttpServletRequest request) throws Exception {
		Usuario usuario = null;
		if (Integer.parseInt(id) > 0) {
			usuario = daoUsuario.getById(id);
		} else {
			usuario = new Usuario();
		}
		view = VIEW_FORMULARIO;
		request.setAttribute("roles", daoRol.getAll());
		request.setAttribute("usuario", usuario);
	}

	private void eliminar(HttpServletRequest request) throws Exception {

		if (id != null) {
			try {
				if (daoUsuario.delete(id)) {
					alert = new Alert(Alert.ALERT_SUCCESS, "Se ha eliminado usuario");
				}

			} catch (Exception e) {

				e.printStackTrace();
				alert = new Alert(Alert.ALERT_WARNING, "No puedes eliminar un usuario asociado a un video ");

			}
			view = VIEW_LISTADO;
			request.setAttribute("usuarios", daoUsuario.getAll());

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
