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
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Rol;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/roles")
public class BackofficeRolController extends HttpServlet implements ICRUDController {

	private static final long serialVersionUID = 1L;
	private static RolDAO daoRol = null;

	private static final String VIEW_LISTADO = "roles/index.jsp";
	private static final String VIEW_FORMULARIO = "roles/form.jsp";

	private String view;
	private Alert alert;

	private String op; // Operacion a realizar

	private String id;
	private String nombre;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoRol = RolDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoRol = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	public void getParameters(HttpServletRequest request) {

		op = (request.getParameter("op") != null) ? request.getParameter("op") : OP_LISTAR;
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
	}
	

	@Override
	public void listar(HttpServletRequest request) throws SQLException {
		
		alert = null;
		view = VIEW_LISTADO;
		request.setAttribute("roles", daoRol.getAll());
	}

	@Override
	public void guardar(HttpServletRequest request) throws SQLException {
		Rol rol = new Rol();
		
		rol.setId(Long.parseLong(id));
		rol.setNombre(nombre);

		try {

			if (rol.getId() > 0) {
				
				daoRol.update(rol); // UPDATE
				alert = new Alert(Alert.SUCCESS, "Rol modificado.");
				
			} else {
				
				daoRol.insert(rol); // INSERT
				alert = new Alert(Alert.SUCCESS, "Rol creado.");
			}

		} catch (SQLIntegrityConstraintViolationException e) { // Error entrada duplicada
			
			alert = new Alert(Alert.WARNING, "El rol ya existe.");

		} catch (SQLException e) { // Longitud de campos incorrecta
			
			alert = new Alert(Alert.WARNING, "Alguno de los campos tiene una longitud incorrecta.");
			e.printStackTrace();

		} catch (Exception e) { // Errores que no son de SQL

			alert = new Alert();
			e.printStackTrace();
		}

		view = VIEW_FORMULARIO;
		request.setAttribute("rol", rol);

	}

	@Override
	public void irFormularioDeAlta(HttpServletRequest request) throws NumberFormatException, SQLException {
		alert = null;

		if (id.equalsIgnoreCase("-1")) {
			request.setAttribute("rol", new Rol());
		} else {
			request.setAttribute("rol", daoRol.getById(Long.parseLong(id)));
		}

		view = VIEW_FORMULARIO;

	}

	@Override
	public void eliminar(HttpServletRequest request) throws SQLException {
		try {

			if (daoRol.delete(Long.parseLong(id))) {
				
				alert = new Alert(Alert.SUCCESS, "Rol eliminado.");
				view = VIEW_LISTADO;
				request.setAttribute("roles", daoRol.getAll());
			}

		} catch (SQLException e) {

			alert = new Alert(Alert.WARNING, "No podemos eliminar el rol porque tiene usuarios asociados.");
			view = VIEW_LISTADO;
		} 	
	}

}
