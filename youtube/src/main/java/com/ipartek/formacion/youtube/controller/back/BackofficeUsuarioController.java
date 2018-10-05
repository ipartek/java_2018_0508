package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;


/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static UsuarioDAO daoUsuario = null;

	public static final String OP_LISTAR = "1";
	public static final String OP_GUARDAR = "2"; // insert id == -1 o update id > 0
	public static final String OP_ELIMINAR = "3";
	public static final String OP_IR_FORMULARIO = "4";

	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMULARIO = "usuarios/form.jsp";
	
	private static final String MSG_USUARIO_REPETIDO = "El usuario ya existe";
	private static final String MSG_LONGITUD_CAMPOS = "Alguno de los campos es demasiado largo.";
	
	private String view;
	private Alert alert;

	private String op; // Operacion a realizar
	
	private String id;
	private String nombre;
	private String password;
	private String rol;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoUsuario = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		alert = new Alert();
		try {

			getParameters(request);

			switch (op) {
			case OP_ELIMINAR:
				eliminarUsuario(request);
				break;
			case OP_IR_FORMULARIO:
				irFormularioAltaUsuario(request);
				break;
			case OP_GUARDAR:
				guardarUsuario(request);
				break;

			default: // LISTAR
				listarUsuarios(request);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LISTADO;
		} finally {
			
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);

		}

	}

	private void listarUsuarios(HttpServletRequest request) throws SQLException {
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", daoUsuario.getAll());
	}

	private void guardarUsuario(HttpServletRequest request) throws SQLException {
		String  msg;
		
		Usuario user = new Usuario();
		
		user.setId(Long.parseLong(id));
		user.setNombre(nombre);
		user.setPass(password);
		user.setRol(Integer.parseInt(rol));
		
		try {

			if (user.getId() > 0) { 
				daoUsuario.update(user); // UPDATE
			} else {
				daoUsuario.insert(user); // INSERT
			}
			
		} catch (SQLIntegrityConstraintViolationException e) {
			alert = new Alert (Alert.WARNING, MSG_USUARIO_REPETIDO);
			
		} catch (SQLException e) {
			alert = new Alert (Alert.WARNING, MSG_LONGITUD_CAMPOS);
			
		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("usuarios", daoUsuario.getAll());

	}

	private void irFormularioAltaUsuario(HttpServletRequest request) throws NumberFormatException, SQLException {
		alert = null;
		
		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("usuario", new Usuario());
		} else {
			request.setAttribute("usuario", daoUsuario.getById(Long.parseLong(id)));
		}
		
		view = VIEW_FORMULARIO;

	}

	private void eliminarUsuario(HttpServletRequest request) throws SQLException {

		try {
			
			daoUsuario.delete(Long.parseLong(id));
			
		} catch (SQLException e) {
			
			alert = new Alert(Alert.WARNING, "No podemos eliminar el usuario porque tiene videos creados.");
		}
		alert = new Alert(Alert.SUCCESS, "Usuario eliminado.");
		
		view = VIEW_LISTADO;
		request.setAttribute("usuario", daoUsuario.getAll());
	}

	private void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		password = request.getParameter("password");
		rol = request.getParameter("rol");
	}

}
