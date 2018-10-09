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

import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	
	private static UsuarioDAO daoUsuario;
	private static RolDAO daoRol;

	private static final String VIEW_LISTADO = "usuarios/index.jsp";
	private static final String VIEW_FORMULARIO = "usuarios/form.jsp";

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
		daoRol = RolDAO.getInstance();
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

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		alert = new Alert();
		try {

			getParameters(request);

			switch (op) {
			case OP_ELIMINAR:
				
				eliminar(request);
				break;
			case OP_IR_FORMULARIO:
				
				irFormularioDeAlta(request);
				break;
			case OP_GUARDAR:
				
				guardar(request);
				break;
			default: // LISTAR
				
				listar(request);
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

	@Override
	public void getParameters(HttpServletRequest request) {
		
		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		password = request.getParameter("password");
		rol = request.getParameter("rol");
	}

	@Override
	public void listar(HttpServletRequest request) throws SQLException {
		
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("usuarios", daoUsuario.getAll());

	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException {
		
		Usuario user = new Usuario();

		user.setId(Long.parseLong(id));
		user.setNombre(nombre);
		user.setPass(password);
		
		user.setRol(daoRol.getById(Integer.parseInt(rol)));

		try {

			if (user.getId() > 0) {
				daoUsuario.update(user); // UPDATE
				alert = new Alert(Alert.SUCCESS, "Usuario modificado.");
				
			} else {
				daoUsuario.insert(user); // INSERT
				alert = new Alert(Alert.SUCCESS, "Usuario insertado.");
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			
			alert = new Alert(Alert.WARNING, "El usuario ya existe.");

		} catch (SQLException e) {
			
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");

		} catch (Exception e) {
			
			e.printStackTrace();
			alert = new Alert();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("usuario", user);
		request.setAttribute("roles", daoRol.getAll());

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws NumberFormatException, SQLException {
		alert = null;

		if (id.equalsIgnoreCase("-1")) { // Crear Usuario
			
			request.setAttribute("usuario", new Usuario());
			
		} else { // Modificar Usuario
			
			request.setAttribute("usuario", daoUsuario.getById(Long.parseLong(id)));
		}

		request.setAttribute("roles", daoRol.getAll());
		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws SQLException {
		try {

			daoUsuario.delete(Long.parseLong(id));
			alert = new Alert(Alert.SUCCESS, "Usuario eliminado.");

		} catch (SQLException e) {

			alert = new Alert(Alert.WARNING, "No podemos eliminar el usuario porque tiene videos creados.");
		
		} finally {
			
			view = VIEW_LISTADO;
			request.setAttribute("usuarios", daoUsuario.getAll());

		}
		
		
	}

}
